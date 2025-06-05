package ExeptionExBank;

import java.util.Random;

public class Main {
    public static String name = "Bedolaga";
    public static int money = 1000;

    public static void main(String[] args) throws incorrectedNameExeption, noMoneyExeption {
        Random random = new Random();
        new CardHolder("SuperUser",random.nextInt(1200));

        try {
            System.out.println(getMoney("Bedolaga", 100));
        } catch (ExeptionExBank.noMoneyExeption | incorrectedNameExeption noMoneyExeption) {
            noMoneyExeption.printStackTrace();
        }
    }

    public static int getMoney(String nameOwner, int sumGetMoney) throws noMoneyExeption, incorrectedNameExeption {
        if (money < sumGetMoney) {
            throw new noMoneyExeption("Денег на счету недостаточно!");
        } else if (!nameOwner.equals(name)) {
            throw new incorrectedNameExeption("Неверное имя пользователя!");
        }
        return money - sumGetMoney;
    }
}
