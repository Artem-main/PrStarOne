package CollectionsHashMap.HashSetHomework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

class ExaminationImplTest {
    private  Map<ExaminationImpl.StudentKey, Integer> results;
    private  Map<String, List<Integer>> subjectGrades;
    private  List<Student> excellentStudents;
    private  List<Student> moreThanOnce;
    private  Set<String> allSubjects;
    private ExaminationImpl.StudentKey first = new ExaminationImpl.StudentKey("A","B", "Front");
    private ExaminationImpl.StudentKey second = new ExaminationImpl.StudentKey("A","B", "Back");
    private ExaminationImpl.StudentKey three = new ExaminationImpl.StudentKey("C","D", "QA");

    @BeforeEach
    void setUp() {
        results = new ConcurrentHashMap<>();
        subjectGrades = new ConcurrentHashMap<>();
        excellentStudents = new ArrayList<>();
        moreThanOnce = new ArrayList<>();
        allSubjects = new HashSet<>();

        results.put(first, 6);
        results.put(second, 3);
        results.put(three, 5);
    }

    @Test
    void addResult() {
        assertFalse(results.isEmpty());
        assertEquals(4, results.get(first));
        assertEquals(3,results.get(second));
        assertEquals(5,results.get(three));
        assertEquals(3,results.size());
    }

    @Test
    void getResult() {
        assertEquals(3,results.size());
        assertNotEquals(5,results.size());
        assertEquals(4,results.getOrDefault(first,4));
        assertEquals(3,results.getOrDefault(second,3));
        assertEquals(5,results.getOrDefault(three,5));
    }

    @Test
    void getAverageGrade() {
//        assertEquals();
    }

    @Test
    void getLastExcellentStudents() {
        excellentStudents.add(new Student("A", "B", "QA", 5));
        assertFalse(excellentStudents.isEmpty());
        assertEquals(1,excellentStudents.size());
        assertEquals("A",excellentStudents.get(0).getFirstName());
        assertEquals("B",excellentStudents.get(0).getLastName());
        assertEquals("QA",excellentStudents.get(0).getSubject());
        assertEquals(5,excellentStudents.get(0).getGrade());
    }

    @Test
    void getAllSubjects() {
        allSubjects.add("QA");
        allSubjects.add("BACK");
        assertFalse(allSubjects.isEmpty());
        assertTrue(allSubjects.contains("QA"));
        assertTrue(allSubjects.contains("BACK"));
    }

    @Test
    void getResultMoreOnce() {
        assertTrue(moreThanOnce.isEmpty());
        moreThanOnce.add(new Student("A", "B", "QA", 5));
        moreThanOnce.add(new Student("A", "B", "QA", 4));
        assertFalse(moreThanOnce.isEmpty());
        assertEquals("A", moreThanOnce.get(0).getFirstName());
    }
}