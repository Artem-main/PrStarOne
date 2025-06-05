package TreeSetAndTreeMap;

import java.util.*;

public class ResultsBoard {

//    a. Каждая запись содержит имя студента и его средний балл.
//b. Реализовать структуру, которая хранит записи в порядке возрастания среднего балла.
//c. Вывести имена 3-х самых успешных студентов в порядке убывания среднего балла.

    TreeSet<SortedStudent> sortedStudentsSet = new TreeSet<>();

    public static void main(String[] args) {
        ResultsBoard resultsBoard = new ResultsBoard();
        resultsBoard.addStudent("Ivan", 3.0f);
        resultsBoard.addStudent("Anna", 5.0f);
        resultsBoard.addStudent("Fedr", 4.0f);

        System.out.println(resultsBoard.sortedStudentsSet);
        System.out.println(resultsBoard.top3());
    }

    void addStudent(String name, float score) {
        SortedStudent sortedStudent = new SortedStudent();
        sortedStudent.score = score;
        sortedStudent.name = name;
        sortedStudentsSet.add(sortedStudent);

    }

    List<String> top3 () {
        List<String> top3 = new ArrayList<>();
        NavigableSet<SortedStudent> reversedStudentsScoreList = sortedStudentsSet.descendingSet();
        for (int i = 0; i < 3; i++) {
            String name = reversedStudentsScoreList.pollFirst().name;
            top3.add(name);
        }
        return top3;
    }

    class SortedStudent implements Comparable <SortedStudent> {
        String name;
        Float score;
        @Override
        public int compareTo(SortedStudent o) {
            return (int) (this.score - o.score);
        }

        @Override
        public String toString() {
            return "\nСтудент " + name + " имеет средний бал - " + score;
        }
    }


}
