package StreamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HomeWork {

    public static void main(String[] args) {
        delRepeatCount();
        summStringFirstLetter();
        findSecondElement();
    }

//    Напишите удаление всех повторяющихся элементов из списка
//Напишите подсчет количества строк в списке, которые начинаются с определенной буквы
//Используя оператор findFirst напишите поиск второго по величине элемента в списке целых чисел

    private static void delRepeatCount () {

        List <Integer> countList = Arrays.asList(1,2,2,3,3,4,4,5,5,6,7,8,9,10);
        System.out.println("Список рандомных чисел: " + countList);
        List<Integer> delCount = countList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Уникальные числа: " + delCount);
    }

    private static void summStringFirstLetter () {
        List<String> namesList = Arrays.asList("Anna", "Angel", "Vanek");
        System.out.println("Список имен: " + namesList);

        List<String> uniName = namesList.stream()
                .filter(e -> e.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Имена на букву А - " + uniName);

        long summLetter = namesList.stream()
                .filter(e -> e.startsWith("A")).count();
        System.out.println("Количество имен на букву А - " + summLetter);
    }

    private static void findSecondElement () {
        List<Integer> countList = Arrays.asList(11,3,7,6,5,6,9,17);
        Integer findSecondCount = countList.stream()
                .sorted(Comparator.reverseOrder()) // сортирует элементы
                .skip(1) // пропускает первый элемент
                .findFirst() // берет перевый элемент после пропущенного
                .orElse(0); // обработка исключения
        System.out.println("Второй элемент в списке - " + findSecondCount);
    }
}
