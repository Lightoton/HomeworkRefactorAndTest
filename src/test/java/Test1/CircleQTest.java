package Test1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CircleQTest {
    private final double RADIUS = 3.15;
    CircleQ circleQ = new CircleQ(RADIUS);

    @Test
    void calculateAreaTest() {
        Assertions.assertEquals(31.17245310524472, circleQ.calculateArea());
    }

    @Test
    void calculateCircumferenceTest() {
        Assertions.assertEquals(19.792033717615695,circleQ.calculateCircumference());
    }
}