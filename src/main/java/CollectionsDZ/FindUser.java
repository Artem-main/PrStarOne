//package CollectionsDZ;
//
//import java.util.Map;
//import java.util.TreeMap;
//import java.util.stream.Collectors;
//
//public class FindUser {
//
////    Задание 1
//public static boolean validateInput(String input, int minLength) {
//    if (input == null || input.trim().isEmpty() || input.length() < minLength) {
//        System.out.println("Ошибка: неверный формат ввода!");
//        return false;
//    }
//    return true;
//}
//
//    public static boolean isValidNumber(String input) {
//        try {
//            Integer.parseInt(input);
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }
//
////    Задание 2
//public void showCourseStatistics() {
//    Map<Integer, Integer> courseMap = new TreeMap<>();
//
//    for (Student student : students) {
//        int course = student.getCourse();
//        courseMap.put(course, courseMap.getOrDefault(course, 0) + 1);
//    }
//
//    for (Map.Entry<Integer, Integer> entry : courseMap.entrySet()) {
//        System.out.println(entry.getKey() + " курс - " + entry.getValue() + " студентов");
//    }
//}
//
////Задание 3
//
//public void searchBySurname() {
//    System.out.print("Введите фамилию/диапазон фамилий: ");
//    String input = scanner.nextLine().trim();
//
//    if (input.isEmpty()) {
//        showAllStudents();
//        return;
//    }
//
//    String[] parts = input.split(",");
//
//    if (parts.length == 1) {
//        searchExactSurname(parts[0].trim());
//    } else if (parts.length == 2) {
//        String surname1 = parts[0].trim();
//        String surname2 = parts[1].trim();
//
//        if (surname1.compareTo(surname2) <= 0) {
//            searchRangeSurnames(surname1, surname2);
//        } else {
//            System.out.println("Ошибка: первая фамилия должна быть раньше второй в алфавитном порядке");
//        }
//    } else {
//        System.out.println("Неверный формат ввода. Попробуйте снова.");
//    }
//}
//
//    private void searchExactSurname(String surname) {
//        List<Student> results = students.stream()
//                .filter(s -> s.getSurname().equalsIgnoreCase(surname))
//                .collect(Collectors.toList());
//        showStudents(results);
//    }
//
//    private void searchRangeSurnames(String surname1, String surname2) {
//        List<Student> results = students.stream()
//                .filter(s -> s.getSurname().compareTo(surname1) >= 0)
//                .filter(s -> s.getSurname().compareTo(surname2) <= 0)
//                .collect(Collectors.toList());
//        showStudents(results);
//    }
//
//}
