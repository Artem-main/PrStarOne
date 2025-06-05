package FileInput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private final String format = ".txt";
    private final String folder = "src/main/java/FileInput/Files/";
    static Scanner scanner = new Scanner(System.in);


    public void userAnswer() {
        System.out.println("Введите имя файле");
        for ( ; ; ) {
            String nameFile = scanner.next();
            String regex = "[а-яёА-ЯЁa-zA-Z]+";
            boolean result = nameFile.matches(regex);
            if (result) {
                saveFileAndTimeSave(nameFile);

                System.out.println("Напишите текст для записи в файл");
                String text = scanner.next();
                writeTextInFile(nameFile, text);
                readTextInFile(nameFile);

                System.out.println("Введите название файла, который надо перезаписать");
                String rewriteNameFile = scanner.next();
                System.out.println("Напишите текст для записи в файл");
                String rewriteText = scanner.next();
                rewriteFile(rewriteNameFile, rewriteText);
                readTextInFile(rewriteNameFile);

                System.out.println("Введите название файла, который найти");
                String nameFindFile = scanner.next();
                findByFileName(nameFindFile);
                break;
            } else System.out.println("Введите название на RU или EN");
        }

    }

    public void saveFileAndTimeSave (String nameFile) {
        File file = new File(folder + nameFile + format);
        try {
            if (file.createNewFile()) {
                FileTime fileTime = (FileTime) Files.getAttribute(Path.of(folder +
                        nameFile + format),"creationTime");
                System.out.println("Создан файл " + nameFile + format +
                        "\n     Время создания файла " + fileTime +
                        "\n     Размер файла " + nameFile.length());
            } else System.out.println("Файл не создан");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeTextInFile (String nameFile,String text) {
        try {
            FileWriter fileWriter = new FileWriter(folder+nameFile+format);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readTextInFile (String nameFile) {
        try {
            List<String> lines = Files.readAllLines(Path.of(folder + nameFile + format));
            for (String line : lines) {
                System.out.println("Вы записали в файл текст: \n    " + line);
            }
        } catch (IOException e) {
            System.out.println("Не получилось прочитать");
            e.printStackTrace();
        }

    }

    public void rewriteFile (String rewriteNameFile, String rewriteText) {
        try {
            FileWriter fileWriter = new FileWriter(folder+rewriteNameFile+format);
            fileWriter.write(rewriteText);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void findByFileName (String fileName) {
        String find = fileName+format;
        File directory = new File(folder);
        String[] flist = directory.list();
        for (int i = 0; i < flist.length; i++) {
            if (find.equals(flist[i])) {
                System.out.println(flist[i] + " найден" );
                List<String> lines = null;
                try {
                    lines = Files.readAllLines(Path.of(folder+find));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (String line : lines) {
                    System.out.println("Файл содержит текст: \n    " + line);
                }
                break;
            } else System.out.println("Не найден");
        }
    }

    public void findFile() {
        File directory = new File(folder);
        File[] files = directory.listFiles();
        int count = 0;
        for (File f : files) {
            count++;
            System.out.println("Файл № " + count + " " + f.getName());
        }

    }

}
