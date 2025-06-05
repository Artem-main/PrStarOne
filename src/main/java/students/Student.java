package students;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Student implements Examination {
    private final Map<String, Score> scoreMap = new HashMap<>();

    @Override
    public void addScore(Score score) {
        scoreMap.put(score.name(), score);
    }

    @Override
    public Score getScore(String name, String subject) {
        return getScore(name, subject);
    }

    @Override
    public double getAverageForSubject(String subject) {
        return 0;
    }

    @Override
    public Set<String> multipleSubmissionsStudentNames() {
        return null;
    }

    @Override
    public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() {
        return null;
    }

    @Override
    public Collection<Score> getAllScores() {
        return null;
    }
}
