package Generic;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Generic<Horse> generic = new Generic<Horse>();

        Pony pony = new Pony();
        generic.addAnimal(pony);

        Mustang mustang = new Mustang();
        generic.addAnimal(mustang);

        List <Mustang> mustangList = new ArrayList<>();
        mustangList.add(new Mustang());
        mustangList.add(new Mustang());
        generic.addAllAnimals(mustangList);

        Generic<Animal> animalGeneric = new Generic<Animal>();
        horseMove(generic,animalGeneric);

    }

    public static <T> void horseMove (Generic<? extends T> source, Generic <? super T> destination) {
        destination.addAllAnimals(source.getAllAnimals());
    }
}
