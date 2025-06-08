package Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Write {
    public static void main(String[] args) throws IOException {
        Voice voice = new Voice();
        voice.setVolume(100);

        Animal animal = new Animal("Dog", "White", 10, voice);
        FileOutputStream fileOutputStream =
                new FileOutputStream("src/main/java/Serialization/animal.ser");
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(animal);
        objectOutputStream.close();
    }
}
