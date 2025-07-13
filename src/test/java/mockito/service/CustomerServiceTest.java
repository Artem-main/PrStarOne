package mockito.service;

import mockito.model.Customer;
import mockito.repository.CustomerRepository;
import mockito.repository.InitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;


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
    @Test
    public void addCustomerTest() {
        CustomerRepository cr = InitRepository.getInstance().getCustomerRepository();
        cr.add(new Customer("Ivan2"));
        assertNotNull(cr.getByName("Ivan2"));
    }

    @Test
    public void getByName() {
        CustomerRepository cr = InitRepository.getInstance().getCustomerRepository();
        cr.add(new Customer("Ivan2"));
        assertNotNull(cr.getByName("Ivan2"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ivan", "Petr", "Alex"})
//    @Test
    public void getAll (String value) {
        CustomerRepository cr = InitRepository.getInstance().getCustomerRepository();
        String list = cr.all().listIterator().next().getName();
        assertEquals(value, list);
    }
}
