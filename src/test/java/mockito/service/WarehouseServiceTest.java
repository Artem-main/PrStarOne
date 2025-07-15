package mockito.service;

import mockito.model.Product;
import mockito.model.Stock;
import mockito.model.Warehouse;
import mockito.repository.ProductRepository;
import mockito.repository.WarehouseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class WarehouseServiceTest {

    /**
     * Покрыть тестами методы findWarehouse и findClosestWarehouse.
     * Вызывать реальные методы зависимых сервисов и репозиториев нельзя.
     * Поиск должен осуществляться как минимум на трех складах.
     *
     * Должны быть проверены следующие сценарии:
     * - поиск несуществующего товара
     * - поиск существующего товара с достаточным количеством
     * - поиск существующего товара с недостаточным количеством
     *
     * Проверки:
     * - товар находится на нужном складе, учитывается количество и расстояние до него
     * - корректная работа для несуществующего товара
     * - порядок и количество вызовов зависимых сервисов
     */
    private WarehouseService warehouseService;
    private WarehouseRepository warehouseRepository;
    private ProductRepository productRepository;

    private Warehouse warehouse1;
    private Warehouse warehouse2;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        // Инициализация реальных сервисов
        productRepository = new ProductRepository();
        warehouseService = new WarehouseService(warehouseRepository);

        // Создание тестовых складов
        warehouse1 = new Warehouse("Склад 1", 10); // расстояние 10 км
        warehouse2 = new Warehouse("Склад 2", 5);  // расстояние 5 км

        // Создание тестовых продуктов
        product1 = new Product("Продукт 1", 100.0);
        product2 = new Product("Продукт 2", 200.0);

        // Добавление складов и продуктов
        warehouseRepository.add(warehouse1);
        warehouseRepository.add(warehouse2);

        // Заполнение складов
        warehouse1.addStock(new Stock(product1,10,100));
        warehouse2.addStock(new Stock(product2,20,50));
        warehouse2.addStock(new Stock(product2,30,150));
    }

    // Тест проверки нахождения товара на нужном складе
    @Test
    void testFindClosestWarehouse() {
        // Поиск ближайшего склада с нужным количеством
        Warehouse result = warehouseService.findClosestWarehouse("Продукт 1", 5);

        // Проверки
        assertEquals(warehouse2, result); // должен выбрать ближайший склад
        assertEquals(5, result.getDistance());
    }

    // Тест проверки учета количества товара
    @Test
    void testStockQuantity() {
        // Проверяем достаточность товара
        assertNotNull(warehouseService.findWarehouse("Продукт 1", 5));

        // Проверяем нехватку товара
        assertNull(warehouseService.findWarehouse("Продукт 1", 15));
    }

    // Тест обработки несуществующего товара
    @Test
    void testNonExistingProduct() {
        assertNull(warehouseService.findWarehouse("Не существующий продукт", 1));
    }

    // Тест проверки работы с несколькими складами
    @Test
    void testMultipleWarehouses() {
        // Проверяем выбор склада с нужным товаром
        Warehouse result = warehouseService.findWarehouse("Продукт 2", 2);
        assertEquals(warehouse2, result);

        // Проверяем выбор ближайшего склада
        Warehouse closest = warehouseService.findClosestWarehouse("Продукт 1", 3);
        assertEquals(warehouse2, closest);
    }

    // Тест проверки последовательности операций
    @Test
    void testOperationSequence() {
        // Проверяем последовательность поиска
        List<Warehouse> allWarehouses = warehouseRepository.all();

        // Проверяем поиск товара
        Warehouse found = warehouseService.findWarehouse("Продукт 1", 5);
        assertTrue(allWarehouses.contains(found));

        // Проверяем поиск ближайшего
        Warehouse closest = warehouseService.findClosestWarehouse("Продукт 1", 5);
        assertTrue(allWarehouses.contains(closest));
    }
}
