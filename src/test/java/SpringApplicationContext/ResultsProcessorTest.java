package SpringApplicationContext;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResultsProcessorTest {
    @Autowired
    private ResultsProcessor resultsProcessor;

    @SneakyThrows
    @Test
    void calculateTotalScore() {
        String keys = "src/test/java/SpringApplicationContext/keys.txt";
        String answer = "src/test/java/SpringApplicationContext/answers.txt";
        int score = resultsProcessor.calculateTotalScore(keys, answer);
        System.out.println("Итоговый балл: " + score);
    }
}