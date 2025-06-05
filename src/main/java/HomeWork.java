import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        System.out.println("Расскажите о вашем друге\nКак зовут Вашего друга?");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Сколько лет Вашему другу?");
        int age = in.nextInt();
        System.out.println("Моему другу " + name + " сейчас " + age + " лет");

    }
}
