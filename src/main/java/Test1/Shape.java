package Test1;

import lombok.AllArgsConstructor;

// Нарушение SOLID:
// Я так понял нужно было что-то вроде такого сделать
public class Shape {
    @AllArgsConstructor
    public static class Circle implements calculateAreaShape {
        private double radius;

        @Override
        public double calculateArea() {
            return Math.PI * Math.pow(radius, 2);
        }
    }

    @AllArgsConstructor
    public static class Square implements calculateAreaShape {
        private double side;

        @Override
        public double calculateArea() {
            return side * side;
        }
    }
//    public enum Type { CIRCLE, SQUARE }
//
//    private Type type;
//
//    public Shape(Type type) {
//        this.type = type;
//    }
//
//    public double calculateArea() {
//        if (type == Type.CIRCLE) {
//            // Вычисление площади круга
//        } else if (type == Type.SQUARE) {
//            // Вычисление площади квадрата
//        }
//        return 0.0;
//    }
}
