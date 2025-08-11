package SpringApplicationContext;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component("ResultsProcessor")
@RequiredArgsConstructor
public class ResultsProcessor {

    @Value("${ege.points.group1}")
    private int group1Points;

    @Value("${ege.points.group2}")
    private int group2Points;

    @Value("${ege.points.group3}")
    private int group3Points;

    public int calculateTotalScore(String keysFile, String answersFile) throws IOException {
        Map<Integer, String> keys = readFile(keysFile);
        Map<Integer, String> answers = readFile(answersFile);

        return calculateScore(keys, answers);
    }

    private Map<Integer, String> readFile(String filePath) throws IOException {
        Map<Integer, String> result = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length == 2) {
                    int number = Integer.parseInt(parts[0].trim());
                    String answer = parts[1].trim();
                    result.put(number, answer);
                }
            }
        }

        return result;
    }

    private int calculateScore(Map<Integer, String> keys, Map<Integer, String> answers) {
        int totalScore = 0;

        for (Map.Entry<Integer, String> entry : keys.entrySet()) {
            int number = entry.getKey();
            String correctAnswer = entry.getValue();
            String studentAnswer = answers.get(number);

            if (studentAnswer != null && studentAnswer.equals(correctAnswer)) {
                if (number <= 4) {
                    totalScore += group1Points;
                } else if (number <= 8) {
                    totalScore += group2Points;
                } else {
                    totalScore += group3Points;
                }
            }
        }

        return totalScore;
    }
}
