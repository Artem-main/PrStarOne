package mockito.service;

import mockito.ProductNotFoundException;
import mockito.model.*;
import mockito.model.Order;
import mockito.repository.CustomerRepository;
import mockito.repository.OrderRepository;
import mockito.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    /*
      Покрыть тестами методы create и addProduct.
      Можно использовать вызовы реальных методов.

      Должны быть проверены следующие сценарии:
      - создание ордера для существующего и нового клиента
      - добавление существующего и несуществующего товара
      - добавление товара в достаточном и не достаточном количестве
      - заказ товара с быстрой доставкой

      Проверки:
      - общая сумма заказа соответствует ожидаемой
      - корректная работа для несуществующего товара
      - порядок и количество вызовов зависимых сервисов
      - факт выбрасывания ProductNotFoundException
     */
    private OrderService orderService;
    private CustomerService customerService;
    private WarehouseService warehouseService;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    private Customer customer;
    private Product existingProduct;
    private Product nonExistingProduct;
    private Warehouse warehouse;

    @BeforeEach
    void setUp() {
        // Создаем реальные экземпляры сервисов
        warehouseService = new WarehouseService();
        orderRepository = new OrderRepository();
        productRepository = new ProductRepository();

        orderService = new OrderService(
                customerService,
                warehouseService,
                orderRepository,
                productRepository
        );

        // Инициализация тестовых данных
        customer = new Customer("Test Customer");
        existingProduct = new Product("Existing Product", 100.0);
        nonExistingProduct = new Product("Non Existing Product", 200.0);
        warehouse = new Warehouse("Main Warehouse");

        // Добавляем существующий продукт в хранилище
        productRepository.add(existingProduct);
//        warehouseService.addStock(warehouse, existingProduct, 10);
    }

    // Тест проверки общей суммы заказа
    @Test
    void testTotalAmount() throws ProductNotFoundException {
        // Создаем заказ
        Order order = orderService.create(customer.getName());

        // Добавляем продукт
        orderService.addProduct(
                order,
                existingProduct.getName(),
                2,
                false
        );

        // Проверяем общую сумму
        assertEquals(200.0, order.getTotal());
        assertEquals(1, order.getDeliveries().size());
    }

    // Тест обработки несуществующего товара
    @Test
    void testNonExistingProduct() {
        // Создаем заказ
        Order order = orderService.create(customer.getName());

        // Проверяем выбрасывание исключения
        assertThrows(ProductNotFoundException.class, () -> {
            orderService.addProduct(
                    order,
                    nonExistingProduct.getName(),
                    1,
                    false
            );
        });
    }

    // Тест проверки работы с реальным хранилищем
    @Test
    void testRealWarehouseOperations() throws ProductNotFoundException {
        // Создаем заказ
        Order order = orderService.create(customer.getName());

        // Проверяем добавление существующего продукта
        orderService.addProduct(
                order,
                existingProduct.getName(),
                1,
                false
        );

        // Проверяем остаток на складе
        assertEquals(9, warehouseService.getStock(warehouse, existingProduct.getName()).getCount());
    }

    // Тест проверки последовательности операций
    @Test
    void testOperationSequence() throws ProductNotFoundException {
        // Создаем заказ
        Order order = orderService.create(customer.getName());

        // Добавляем продукт
        orderService.addProduct(
                order,
                existingProduct.getName(),
                1,
                false
        );

        // Проверяем последовательность операций
        assertTrue(orderRepository.all().contains(order));
        assertEquals(1, order.getDeliveries().size());
        assertEquals(1, orderRepository.size());
    }

}
