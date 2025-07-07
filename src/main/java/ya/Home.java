package ya;

import java.util.Scanner;

public class Home {

    public static int Scanner () {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        String [][] arr = new String[n*x][m*y];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = scanner.next();
                if (arr[i][j].equals("X") || arr[i][j].equals("x")) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Scanner());
    }
}
