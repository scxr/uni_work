package week5;

public class Circle extends Shape {
    private double radius;
    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    
    public double setRadius(double value) {
        double old_value = this.radius;
        this.radius = value;
        return old_value;
    }

    public double getArea() {
        return 3.14 * (radius * radius);
    }

    public double getPerimeter() {
        return 3.14 * radius * 2;
    }

    @Override
    public String toString() {
        //return getRadius();
        //String original = Shape.class.toString();
        return "A circle with radius " + getRadius() + " which is a subclass of ";
    }
}
