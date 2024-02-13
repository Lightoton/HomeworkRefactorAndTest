package Test1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalcITest{

    CalcI calcI = new CalcI();
    public static Stream<Arguments> getNumberPositiveTest(){
        return Stream.of(
                Arguments.of(1,new double[]{3.5}),
                Arguments.of(2,new double[]{5}),
                Arguments.of(3,new double[]{3,5,5})
        );
    }
    public static Stream<Arguments> getNumberNegativeTest(){
        return Stream.of(
                Arguments.of(1,new double[]{}),
                Arguments.of(-1,new double[]{3.5}),
                Arguments.of(2,new double[]{3.5,-4}),
                Arguments.of(2,new double[]{0}),
                Arguments.of(3,new double[]{3,2,5}),
                Arguments.of(4,new double[]{3,2,5}),
                Arguments.of(3,new double[]{3,5,5,7})
        );
    }
    @ParameterizedTest
    @MethodSource("getNumberNegativeTest")
    public void testCalculateAreaNegativeTest(int shapeType, double... params) {
        Assertions.assertThrows(IllegalArgumentException.class,() -> calcI.calculateArea(shapeType,params));
    }
    @ParameterizedTest
    @MethodSource("getNumberPositiveTest")
    public void testCalculateAreaPositiveTest(int shapeType, double... params) {
        double result = calcI.calculateArea(shapeType,params);
        switch (shapeType){
            case 1 -> Assertions.assertEquals(38.48451000647496,result);
            case 2 -> Assertions.assertEquals(25,result);
            case 3 -> Assertions.assertEquals(7.1545440106270926,result);
        }
    }
}