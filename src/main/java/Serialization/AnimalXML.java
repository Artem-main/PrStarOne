package Serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class AnimalXML {
    public static void main(String[] args) throws JAXBException {
        Voice voice = new Voice();
        voice.setVolume(100);
        Animal animal = new Animal("Dog", "White", 10, voice);

        File file = new File("src/main/java/Serialization/animal.xml");

        JAXBContext jaxbContext = JAXBContext.newInstance(Animal.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(animal,file);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Animal saveAnimal = (Animal) unmarshaller.unmarshal(file);

        System.out.println(saveAnimal.getAge() + "\n" +
                saveAnimal.getName() + "\n" +
                saveAnimal.getColor() + "\n" +
                saveAnimal.getName());
    }
}
