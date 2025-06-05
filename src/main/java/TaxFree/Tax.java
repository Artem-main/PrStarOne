package TaxFree;
import java.util.InputMismatchException;
import java.util.Scanner;
import static TaxFree.Tax.PriceTagArray.*;

public class Tax {
    public static Scanner scanner = new Scanner(System.in);
    private static final double TAX_1 = 10;
    private static final double TAX_2 = 20;
    private static final double TAX_3 = 30;
    private static final String regex = "^[\\d+]$";

    public static void main(String[] args) throws InputMismatchException {

        initTable();

        System.out.print("Введите сумму: ");
        try {
            double unswerUser = scanner.nextDouble();
            boolean resultRegex = regex.matches(String.valueOf(unswerUser));
            if (resultRegex != true) {
                comparisonWithResponse(unswerUser);
            } else System.out.println("хуета");
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели некорректную сумму");
        }
    }

    static class PriceTagArray {
        private final double tax;
        static final PriceTagArray[] priceTagArray = new PriceTagArray[3];

        public PriceTagArray(double tax) {
            this.tax = tax;
        }

        public double getTax() {
            return tax;
        }
    }

    public static void initTable() {
        priceTagArray[0] = new PriceTagArray(TAX_1);
        priceTagArray[1] = new PriceTagArray(TAX_2);
        priceTagArray[2] = new PriceTagArray(TAX_3);
    }
    public static void comparisonWithResponse (double summ) {
        if (summ >= 0 && summ <= 100) {
            System.out.println("Налог " + priceTagArray[0].tax + "%" + "\nСумма налога: " + (summ/100)*priceTagArray[0].tax + "y.e.");
        } else if (summ >= 101 && summ <= 1000) {
            System.out.println("Налог " + priceTagArray[1].tax + "%" + "\nСумма налога: " + (summ/100)*priceTagArray[1].tax + "y.e.");
        } else if (summ >= 1001 && summ <= 10000) {
            System.out.println("Налог " + priceTagArray[2].tax + "%" + "\nСумма налога: " + (summ/100)*priceTagArray[2].tax + "y.e.");
        } else System.out.println("Сумма превышает бюджет банка");
    }
}
