package exampleCircle.circle;

public class Circle {
    private double numberPI = Math.PI;
    private double area;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("A cannot be less then 0");
        }
        this.radius = radius;
    }

    public double getArea() {
        return Math.pow(radius, 2) * numberPI;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
