package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

    private static int maxSizeArray = 10;
    private static int minSizeArray = 0;
    private static int[] arrayExtension = new int[maxSizeArray];
    static Scanner reader = new Scanner(System.in);
    static String answerUser;
    private static final String goOut = "Выход";

    public static void main(String[] args) {
        scanner();
        reader.close();
    }

    public static void scanner() {
        do {
            System.out.println("Введите 2 числа: ");
            double first = reader.nextDouble();
            double second = reader.nextDouble();

            System.out.print("Введите оператор: (+, -, *, /): ");

            char operator = reader.next().charAt(0);
            double result = 0.0;

            switch (operator) {
                case '+' -> result = first + second;
                case '-' -> result = first - second;
                case '*' -> result = first * second;
                case '/' -> result = first / second;
                default -> {
                    System.out.println("Введите корректный оператор");
                    return;
                }
            }

            System.out.printf("%.1f %c %.1f = %.1f", first, operator, second, result);

            int count = 0;
            for (int i = 0; i < arrayExtension.length; i++) {
                if (arrayExtension[i] == count) {
                    arrayExtension[i] = (int) result;
                    count++;
                    if (count == maxSizeArray) {
                            addArrayLength(1);
                    }
                }
            }
            System.out.println("\nХотите продолжить? Y/N");

            do {
                answerUser = reader.next();
                if (answerUser.equals("Y")) {
                    scanner();
                } else if (answerUser.equals("N")) {
                    break;
                } else if (answerUser.equals(goOut)) {
                    break;
                } else System.out.println("Введите корректный ответ");
            } while (!answerUser.equals("Y") || !answerUser.equals("N"));
            break;
        } while (answerUser.equals(goOut));
        print();
    }

    static void addArrayLength (int value) {
        if (minSizeArray >=arrayExtension.length){
            maxSizeArray += 1;
            int [] temp = Arrays.copyOf(arrayExtension, minSizeArray);
            arrayExtension = new int[maxSizeArray];
            for (int i = 0; i < temp.length; i++) {
                arrayExtension[i] = temp [i];
            }
        }
        arrayExtension[minSizeArray] = value;
        minSizeArray++;
    }

    static void print () {
        for (int i = 0; i < arrayExtension.length; i++) {
            System.out.print(" " + arrayExtension[i] + " ");
        }
    }
}
/*
 *     ДЗ
 *     1. добавьте массив для сохранения результатов размерностью 10
 *     если результатов стало больше мы завершаем работы, информируя пользователя и распечатывая результаты
 *
 *     2. поместите код в цикл для возможности использования без постоянного запуска программы.
 *     Для выхода пусть буду слова "выход"
 *     T.е. пользователь ввел выход - мы просто выходим, сохраняя результат в массиве результатов и выводим массив на консоль.
 *
 *
 */
