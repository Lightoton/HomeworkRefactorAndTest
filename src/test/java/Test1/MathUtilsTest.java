package Test1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    MathUtils utils = new MathUtils();
    @Test
    void calculateSumArrTest() {
        Assertions.assertEquals(10,utils.calculateSum(new int[] {1,2,5,2}));
    }

    @Test
    void CalculateSumListTest() {
        Assertions.assertEquals(25,utils.calculateSum(Arrays.asList(2,8,5,6,4)));
    }
}