package mockito.service;

import mockito.model.Customer;
import mockito.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    /**
     * Тест 1 - Получение покупателя "Ivan"
     * Проверки:
     * - очередность и точное количество вызовов каждого метода из CustomerRepository
     *
     * Тест 2 - Получение покупателя "Oleg"
     * Проверки:
     * - очередность и точное количество вызовов каждого метода из CustomerRepository
     * - в метод getOrCreate была передана строка "Oleg"
     */
    @Mock
    private CustomerRepository cr;
    private List<String> mockList;

    // Инъекция мока в тестируемый объект
    @InjectMocks
    private CustomerService customerService;

    // Метод инициализации моков перед каждым тестом
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockList = new ArrayList<>();
    }
    @ParameterizedTest
    @ValueSource(strings = {"Ivan", "Petr", "Alex"})
    public void addCustomerTest(String name) {
//        Когда создается имя
        customerService.getOrCreate(name);
//        Тогда проверяется
        verify(cr).getByName(name);
    }

    @Test
    public void getByName() {
        // Подготовка данных для теста
        Customer ivan = new Customer("Ivan");

        // Настройка поведения мока - при поиске "Ivan" возвращать созданного клиента
        when(cr.getByName("Ivan"))
                .thenReturn(ivan);

        // Выполнение тестируемого действия
        Customer result =
                customerService.getOrCreate("Ivan");

        // Проверка результатов
        // Проверяем, что метод getByName был вызван ровно 1 раз
        verify(cr, times(1)).getByName("Ivan");

        // Проверяем, что возвращенный объект - это именно Ivan
        assertEquals("Ivan", result.getName());
    }

    @Test
    public void getAll () {
//        Дано
        List<Customer> expectedName = new ArrayList<>();
        expectedName.add(new Customer("Ivan"));
        expectedName.add(new Customer("Petr"));
        expectedName.add(new Customer("Alex"));
//        Когда, настройка мока, при вызове getAll возвращается список Дано
        when(cr.all()).thenReturn(expectedName);
//        Вызов тестируемого метода
        List<Customer> actualNames = cr.all();
//        Тогда проверяем результаты
        verify(cr).all();
//        Сравнение списков
        assertEquals(expectedName, actualNames);
//        Проверка размера списка
        assertEquals(3,actualNames.size());
    }

    @Test
    public void getSize () {
        int repoSize = 3;
        List<Customer> listAllCustomer = new CustomerRepository().all();
//        Проверка что список не пустой
        assertNotNull(listAllCustomer);
//        Проверка размера списка (известен размер 3)
        assertEquals(repoSize, listAllCustomer.size());

    }

    @Test
    public void testOleg () {
        // Подготовка данных для теста
        Customer oleg = new Customer("Oleg");

        // Настройка поведения мока:
        // 1. При поиске "Oleg" возвращать null (клиент не найден)
        when(cr.getByName("Oleg"))
                .thenReturn(null);

        // 2. При добавлении клиента возвращать его же
        when(customerService.getOrCreate("Oleg"))
                .thenReturn(oleg);

        // Создание объекта для проверки порядка вызовов
        InOrder inOrder = inOrder(cr);

        // Выполнение тестируемого действия
        Customer result = customerService.getOrCreate("Oleg");

        // Проверка порядка и количества вызовов
        inOrder.verify(cr).getByName("Oleg");  // Сначала поиск
        inOrder.verify(cr).add(oleg);         // Затем добавление

        // Проверка параметров вызова
        verify(cr).getByName(eq("Oleg"));     // Проверяем точную строку

        // Проверка результата
        assertNotNull(result);                                // Результат не null
        assertEquals("Oleg", result.getName());               // Имя совпадает
    }
}
