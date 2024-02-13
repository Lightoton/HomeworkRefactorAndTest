package Test1;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {

    @Test
    public void circleTest(){
        Shape.Circle circle = new Shape.Circle(5);
        double expected = Math.PI * 5 * 5;
        Assertions.assertEquals(expected,circle.calculateArea(),0.0001);
    }
    @Test
    public void squareTest(){
        Shape.Square square = new Shape.Square(4);
        double expected = 16;
        Assertions.assertEquals(expected,square.calculateArea());
    }

}