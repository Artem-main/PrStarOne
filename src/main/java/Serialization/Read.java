package Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Read {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream =
                new FileInputStream("src/main/java/Serialization/animal.ser");

        ObjectInputStream objectInputStream =
                new ObjectInputStream(fileInputStream);

        Animal animal = (Animal) objectInputStream.readObject();

        System.out.println(animal.getAge() + "\n" +
                animal.getName() + "\n" +
                animal.getColor() + "\n" +
                animal.getName());

    }
}
