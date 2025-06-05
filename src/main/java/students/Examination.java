package students;

import java.util.Collection;
import java.util.Set;

//Задача: Реализовать учет успеваемости студентов по предметам.
//        У каждой сдачи есть имя, фамилия, предмет и оценка.
//
//        Требования:
//
//        — Реализовать интерфейс, у которого есть методы.
//
//        • добавить сдачу студента (в зачет идет только последняя сдача, хранить все сдачи студента по одному и тому же предмету не нужно)
//
//        • получить сдачу студента по имени, фамилии и предмету
//
//        • вывод средней оценки по предмету вывод тех студентов, кто сдавал более одного раза
//
//        • вывод последних пяти студентов, сдавших на отлично
//
//        • вывод всех сданных предметов
//
//        — Сделать кеш для для вывода средней оценки по предмету за пределами интерфейса Examination.

public interface Examination {

    void addScore(Score score);

    Score getScore(String name, String subject);

    double getAverageForSubject(String subject);

    Set<String> multipleSubmissionsStudentNames();

    Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject();

    Collection<Score> getAllScores();
}
