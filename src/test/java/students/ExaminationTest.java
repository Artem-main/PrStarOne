package students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

public class ExaminationTest implements Examination{

    private Examination examination;

    @BeforeEach
    void setUp () {
        examination = new ExaminationTest();
    }

    @Test
    public void addScore(Score score) {
        score = new Score("Ivan", "IT", 3);
        examination.addScore(score);

        Score actual = examination.getScore("Ivan", "IT");
        Assertions.assertEquals(actual, score);
    }

    @Test
    public Score getScore(String name, String subject) {
        return examination.getScore(name, subject);
    }

    @Test
    public double getAverageForSubject(String subject) {
        return 0;
    }

    @Test
    public Set<String> multipleSubmissionsStudentNames() {
        return null;
    }

    @Test
    public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() {
        return null;
    }

    @Test
    public Collection<Score> getAllScores() {
        return null;
    }
}
