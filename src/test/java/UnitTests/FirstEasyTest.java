package UnitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//        1. Напишите минимум два теста для предоставленного ниже метода.
//        2. Убедитесь, что ваши тесты покрывают различные кейсы, включая типичные сценарии использования и граничные значения.
//        3. Для каждого теста укажите ожидаемый результат.
//        4. Пришлите скриншот написанных тестов и результатов их выполнения.
//        Дополнительное задание:
//        5. Реализуйте дополнительные тест-кейсы для представленного метода, которые могли бы увеличить покрытие кода и улучшить его надежность.
class FirstEasyTest {

    @Test
    public void testZero() {
        assertFalse(FirstEasy.isPrime(0), "Число 0 не должно быть простым");
    }

    // Базовый тест для простого числа
    @Test
    public void testPrimeNumber() {
        assertTrue(FirstEasy.isPrime(7), "Число 7 должно быть простым");
    }

    // Тест для числа 2 - наименьшее простое число
    @Test
    public void testMinimalPrime() {
        assertTrue(FirstEasy.isPrime(2), "Число 2 должно быть простым");
    }

    // Тест для составного числа
    @Test
    public void testCompositeNumber() {
        assertFalse(FirstEasy.isPrime(10), "Число 10 не должно быть простым");
    }

    // Тест для числа 1
    @Test
    public void testOne() {
        assertFalse(FirstEasy.isPrime(1), "Число 1 не должно быть простым");
    }

    // Тест для отрицательного числа
    @Test
    public void testNegativeNumber() {
        assertFalse(FirstEasy.isPrime(-5), "Отрицательные числа не могут быть простыми");
    }

    // Тест для большого простого числа
    @Test
    public void testLargePrime() {
        assertTrue(FirstEasy.isPrime(997), "Число 997 должно быть простым");
    }

    // Тест для большого составного числа
    @Test
    public void testLargeComposite() {
        assertFalse(FirstEasy.isPrime(1000), "Число 1000 не должно быть простым");
    }
}