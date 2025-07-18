package homework.service;

import homework.model.Distance;
import homework.model.Gender;
import homework.model.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;

class ResultsReaderTest {
    // Создаем экземпляр тестируемого класса
    private ResultsReader resultsReader;
    // Создаем мок для парсера результатов
    private ResultParser resultParser;

    // Метод, который выполняется перед каждым тестом
    @BeforeEach
    void setUp() {
        // Создаем мок парсера
        resultParser = new ResultParser();
        // Инициализируем тестируемый класс с моком
        resultsReader = new ResultsReader(resultParser);
    }

    // Тест для проверки чтения корректного файла
    @Test
    void testReadFromValidFile(@TempDir Path tempDir) throws IOException {
        // Создаем временный файл для тестирования
        Path testFile = tempDir.resolve("results.csv");

        // Формируем тестовые данные в формате "Имя, Пол, Дистанция, Время"
        List<String> lines = List.of(
                "Иван Иванов,M,10 km,55:20", // строка 1
                "Анна Петрова,F,5 km,30:15",  // строка 2
                "Петр Сидоров,M,10 km,52:45"  // строка 3
        );

        // Записываем тестовые данные в файл
        Files.writeString(testFile, String.join("\n", lines));

        // Читаем результаты из файла
        List<Result> results = resultsReader.readFromFile(testFile);

        // Проверяем количество прочитанных результатов
        assertEquals(3, results.size(), "Должно быть прочитано 3 результата");

        // Проверяем первый результат
        Result firstResult = results.get(0);
        assertEquals("Иван Иванов", firstResult.person().name(), "Неверное имя участника");
        assertEquals(Gender.MALE, firstResult.person().gender(), "Неверный пол");
        assertEquals(Distance.TEN_KM, firstResult.distance(), "Неверная дистанция");
//        assertEquals("55:20", firstResult.time(), "Неверное время");

        // Проверяем второй результат
        Result secondResult = results.get(1);
        assertEquals("Анна Петрова", secondResult.person().name(), "Неверное имя участника");
        assertEquals(Gender.FEMALE, secondResult.person().gender(), "Неверный пол");
        assertEquals(Distance.FIVE_KM, secondResult.distance(), "Неверная дистанция");
//        assertEquals("30:15", secondResult.time(), "Неверное время");

        // Проверяем третий результат
        Result thirdResult = results.get(2);
        assertEquals("Петр Сидоров", thirdResult.person().name(), "Неверное имя участника");
        assertEquals(Gender.MALE, thirdResult.person().gender(), "Неверный пол");
        assertEquals(Distance.TEN_KM, thirdResult.distance(), "Неверная дистанция");
//        assertEquals("52:45", thirdResult.time(), "Неверное время");
    }

    // Тест для проверки пустого файла
    @Test
    void testEmptyFile(@TempDir Path tempDir) throws IOException {
        // Создаем пустой файл
        Path emptyFile = tempDir.resolve("empty.txt");
        Files.createFile(emptyFile);

        // Читаем результаты
        List<Result> results = resultsReader.readFromFile(emptyFile);

        // Проверяем, что список пустой
        assertTrue(results.isEmpty(), "Для пустого файла должен быть пустой список");
    }
}