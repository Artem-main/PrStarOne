package Car;

public class Car implements Drivable {

    private String name;
    private int weight;
    private int hp;
    private CarType carType;
    private Engine engine;
    private Wheel wheel;


    public Car(String name, int weight, int hp, CarType carType) {
        this.name = name;
        this.weight = weight;
        this.hp = hp;
        this.engine = new Engine();
        this.wheel = new Wheel();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    @Override
    public void drive() {

    }
}
