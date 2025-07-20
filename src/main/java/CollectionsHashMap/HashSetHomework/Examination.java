package CollectionsHashMap.HashSetHomework;

import java.util.List;
import java.util.Set;

public interface Examination {
    // Добавить сдачу студента
    void addResult(String firstName, String lastName, String subject, int grade);

    // Получить сдачу студента
    int getResult(String firstName, String lastName, String subject);

    // Получить среднюю оценку по предмету
    double getAverageGrade(String subject);

    // Получить последних 5 студентов с оценкой 5
    List<Student> getLastExcellentStudents();

    // Получить все сданные предметы
    Set<String> getAllSubjects();
}

class Student {
    private String firstName;
    private String lastName;
    private String subject;
    private int grade;

    public Student(String firstName, String lastName, String subject, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
