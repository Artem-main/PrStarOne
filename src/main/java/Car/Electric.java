package Car;

public class Electric extends Car {

    public Electric (String name, int weight, int hp, CarType carType) {
        super(name, weight, hp, carType);
    }

    @Override
    public void drive () {
        getWheel().wheelOnCar();
    }
}
