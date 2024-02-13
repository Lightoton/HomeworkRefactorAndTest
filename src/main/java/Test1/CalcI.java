package Test1;

// Нарушение CODE SMELLS: Магические числа
class Calc {
    public double calculateArea(int shapeType, double... params) {
        if (shapeType == 1) { // 1- круг
            double radius = params[0];
            return Math.PI * radius * radius;
        } else if (shapeType == 2) { // 2 - квадрат
            double side = params[0];
            return side * side;
        } else if (shapeType == 3) { // 3 - треугольник
            double a = params[0];
            double b = params[1];
            double c = params[2];
            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
        return 0.0;
    }
}

public class CalcI {

    public static final int CIRCLE = 1;
    public static final int SQUARE = 2;
    public static final int TRIANGLE = 3;
    public double calculateArea(int shapeType, double... params) {
        if (shapeType > 3 || shapeType < CIRCLE) throw new IllegalArgumentException("Unsupported shape type!");
        if (params.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        for (int i = 0; i < params.length; i++) {
            if (params[i] < 0) throw new IllegalArgumentException("Param " + i + "is negative!");
        }
        if (shapeType == CIRCLE && params[0] > 0) { // 1- круг
            return calculateAreaCircle(params[0]);
        } else if (shapeType == SQUARE && params[0] > 0) { // 2 - квадрат
            return calculateAreaSquare(params[0]);
        } else if (shapeType == TRIANGLE && params.length == TRIANGLE) { // 3 - треугольник
            return calculateAreaTriangle(params);
        }
        throw new IllegalArgumentException("Missing elements!");
    }

    private static double calculateAreaCircle(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    private static double calculateAreaSquare(double side) {
        return Math.pow(side, SQUARE);
    }

    private static double calculateAreaTriangle(double... params) {
        double a = params[0];
        double b = params[1];
        double c = params[2];
        if (a + b <= c || b + c <= a || c + a <= b)
            throw new IllegalArgumentException("Such a triangle does not exist!");
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
