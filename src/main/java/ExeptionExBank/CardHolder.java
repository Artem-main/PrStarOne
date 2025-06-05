package ExeptionExBank;

public class CardHolder {
    private static final String correctedNameUser = "SuperUser";
    private final int fullSummOmCard = 1000;

    public  CardHolder(String nameUser, int moneyOut) throws incorrectedNameExeption, noMoneyExeption {
        if (!nameUser.equals(correctedNameUser)) {
            throw new incorrectedNameExeption("Неверное имя пользователя");
        } else if (moneyOut > fullSummOmCard) {
            throw  new noMoneyExeption("Недостаточно денег на счету");
        } else if (fullSummOmCard <= 0) {
            System.out.println("На счету нет денег!");
        }
        System.out.println(fullSummOmCard - moneyOut);
    }
}
