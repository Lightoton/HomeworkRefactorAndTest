package Test1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    @Test
    void toUpperCase() {
        Assertions.assertEquals("ABCD",StringUtils.toUpperCase("aBcd"));
    }
}