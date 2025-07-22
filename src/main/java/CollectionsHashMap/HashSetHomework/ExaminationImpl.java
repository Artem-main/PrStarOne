package CollectionsHashMap.HashSetHomework;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ExaminationImpl implements Examination {
    private final Map<StudentKey, Integer> results = new ConcurrentHashMap<>();
    private final Map<String, List<Integer>> subjectGrades = new ConcurrentHashMap<>();
    private final List<Student> excellentStudents = new ArrayList<>();
    private final List<Student> moreThanOnce = new ArrayList<>();
    private final Set<String> allSubjects = new HashSet<>();

    @Override
    public void addResult(String firstName, String lastName, String subject, int grade) {
        StudentKey key = new StudentKey(firstName, lastName, subject);
        results.put(key, grade);

        // Обновляем список оценок по предмету
        subjectGrades.computeIfAbsent(subject, k -> new ArrayList<>()).add(grade);

        // Добавляем в список всех предметов
        allSubjects.add(subject);

        // Если оценка 5, добавляем в список отличников
        if (grade == 5) {
            excellentStudents.add(new Student(firstName, lastName, subject, grade));
            // Оставляем только последние 5 записей
            if (excellentStudents.size() > 5) {
                excellentStudents.remove(0);
            }
        }

        if (results.containsKey(key)) {
            moreThanOnce.add(new Student(firstName, lastName, subject, grade));
        }
    }

    @Override
    public int getResult(String firstName, String lastName, String subject) {
        StudentKey key = new StudentKey(firstName, lastName, subject);
        return results.getOrDefault(key, -1); // -1 если не найдено
    }

    @Override
    public double getAverageGrade(String subject) {
        List<Integer> grades = subjectGrades.get(subject);
        if (grades == null || grades.isEmpty()) return 0.0;

        return grades.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    @Override
    public List<Student> getLastExcellentStudents() {
        return excellentStudents;
    }

    @Override
    public Set<String> getAllSubjects() {
        return allSubjects;
    }

    @Override
    public List <Student> getResultMoreOnce() {
        return moreThanOnce;
    }

    static class StudentKey {
        private final String firstName;
        private final String lastName;
        private final String subject;

        public StudentKey(String firstName, String lastName, String subject) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.subject = subject;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StudentKey that = (StudentKey) o;
            return Objects.equals(firstName, that.firstName) &&
                    Objects.equals(lastName, that.lastName) &&
                    Objects.equals(subject, that.subject);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, subject);
        }
    }
}
