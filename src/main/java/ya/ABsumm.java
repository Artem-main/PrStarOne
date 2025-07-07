package ya;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class ABsumm {
    public static int  Scanner () {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        return a+b;
    }

    public static void  summInFile () throws IOException {
        List<String> listCount = Files.readAllLines(Path.of("src/main/java/ya/input.txt"));
        for (String line : listCount) {
            System.out.println("Текст в файле: \n    " + line);
        }
    }

    public static void scanSummFile () throws IOException {
        File f = new File("src/main/java/ya/input.txt");
        int summ = 0;
        Scanner sc = new Scanner(f);
        while (sc.hasNextInt()) {
            summ += sc.nextInt();
        }
        FileWriter fileWriter = new FileWriter("src/main/java/ya/output.txt");
        fileWriter.write(String.valueOf(summ));
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        scanSummFile();
    }
}
