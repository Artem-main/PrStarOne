package CollectionsHashMap.HashSetHomework;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class AverageGradeCache {
    private final ConcurrentMap<String, Double> cache = new ConcurrentHashMap<>();

    public double getCachedAverageGrade(Examination examination, String subject) {
        return cache.computeIfAbsent(subject, s -> examination.getAverageGrade(s));
    }
}
