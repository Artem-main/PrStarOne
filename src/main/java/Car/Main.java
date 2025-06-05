package Car;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("df",1,2,CarType.SEDAN);
        System.out.println("Name: " + car.getName() + "\n" +
                "Weight: " + car.getWeight() + "\n");

        System.out.println();
    }
    public void driveCar (Drivable drivable) {
        drivable.drive();
    }
}
