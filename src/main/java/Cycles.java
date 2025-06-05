import java.util.Scanner;

public class Cycles {
    public static final String FISS_THREE = "fizz";
    public static final String FISS_FIVE = "buzz";
    public static final String FISS_THREE_AND_FIVE = "fizzbuzz";

    public static void main(String[] args) {
        int [] findNumbers = new int [ScanNumber.numb + 1];
        int nullPoint = 0;
        for (int i = 0; i < findNumbers.length; i++) {
            findNumbers [i] = nullPoint++;
        }
        for (int findNumber : findNumbers) {
            if (findNumber % 3 == 0 && findNumber % 5 == 0 && findNumber !=0) {
                System.out.print(FISS_THREE_AND_FIVE + " ");
                continue;
            } else if (findNumber % 3 == 0 && findNumber !=0) {
                System.out.print(FISS_THREE + " ");
                continue;
            } else if (findNumber % 5 == 0 && findNumber !=0) {
                System.out.print(FISS_FIVE + " ");
                continue;
            }
            System.out.print(findNumber + " ");
        }
        ScanNumber.sc.close();
    }
    static class ScanNumber {
        static Scanner sc = new Scanner(System.in);
        static int numb = sc.nextInt();
    }
}