package Test1;


public class CircleQ {
    private final double radius;
    public final double PI = Math.PI;

    public CircleQ(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return PI * Math.pow(radius,2);
    }
    
    public double calculateCircumference() {
        return 2 * PI * radius;
    }
}

