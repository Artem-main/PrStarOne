package Generic;

import java.util.ArrayList;
import java.util.List;

public class Generic <T> {

    private List <T> horses = new ArrayList<>();

    public T addAnimal (T horse) {
        horses.add(horse);
        return horse;
    }
    public List <T> getAllAnimals () {
        return horses;
    }
    public void addAllAnimals (List<? extends T> AddAllHorses) {
        horses.addAll(AddAllHorses);

    }
}
