package Test1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SUTTest {
    String testStr = "aBcD";
    @Test
    void toUpperCase1() {
        Assertions.assertEquals(testStr.toUpperCase(),SUT.toUpperCase1(testStr));
    }

    @Test
    void toLowerCase2() {
        Assertions.assertEquals(testStr.toLowerCase(),SUT.toLowerCase2(testStr));
    }

    @Test
    void toCharArray2() {
        Assertions.assertArrayEquals(testStr.toCharArray(),SUT.toCharArray2(testStr));
    }
}