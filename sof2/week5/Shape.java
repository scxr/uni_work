package week5;

public class Shape {
    private String color;
    private boolean filled;
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public Shape(){
        this.color = "red";
        this.filled = true;
    }

    public Shape(double radius) {
        this.color = "red";
        this.filled = true;
    }

    public boolean isFilled() {
        return this.filled;
    }

    public String getColor() {
        return this.color;
    }

    public String setColor(String value) {
        String old_value = this.color;
        this.color = value;
        return old_value;
    }

    public boolean setFilled(boolean value) {
        boolean old_value = this.filled;
        this.filled = value;
        return old_value;
    }

    public String toString() {
        if (isFilled() == true) {
            return "A shape with color of " + this.color + "and filled";
        } else {
            return "A shape with color of " + this.color + "and not filled";
        }
    }
}