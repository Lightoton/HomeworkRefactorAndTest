package Test1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class D1Test {
    D1 d1 = new D1();
    List<Double> testList = Arrays.asList(5.5,6.89,7.4,9.48,2.12,1.485,4.499,8.148,6.14);
    @Test
    void calculateAverageValueForGivenListNew() {
        Assertions.assertEquals(5.7402,d1.calculateAverageValueForGivenListNew(testList),0.0001);
    }
}