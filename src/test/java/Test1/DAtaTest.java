package Test1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAtaTest {
    DAta dAta = new DAta();
    List<Double> testList = Arrays.asList(4.5,15.5,8.4,20.15);
    @Test
    void standardDeviationTest() {
        Assertions.assertEquals(6.0787,dAta.standardDeviation(testList),0.0001);
    }
}