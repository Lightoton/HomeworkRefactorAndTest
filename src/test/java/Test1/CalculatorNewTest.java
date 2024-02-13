package Test1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.naming.OperationNotSupportedException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorNewTest {
    CalculatorNew calculatorNew = new CalculatorNew();
    public static Stream<Arguments> getNumPositiveTest(){
        return Stream.of(
                Arguments.of(5,5,"+"),
                Arguments.of(5,7,"-"),
                Arguments.of(7,8,"*"),
                Arguments.of(8,2,"/")
        );
    }

    @ParameterizedTest
    @MethodSource("getNumPositiveTest")
    void calcPositiveTest(int a, int b, String op) throws OperationNotSupportedException {
        switch (op){
            case "+" -> Assertions.assertEquals(10,calculatorNew.calc(a,b,op));
            case "-" -> Assertions.assertEquals(-2,calculatorNew.calc(a,b,op));
            case "*" -> Assertions.assertEquals(56,calculatorNew.calc(a,b,op));
            case "/" -> Assertions.assertEquals(4,calculatorNew.calc(a,b,op));
        }
    }
    @Test
    void calcExceptionTest(){
        Assertions.assertThrows(ArithmeticException.class, () -> calculatorNew.calc(5,0,"/"));
        Assertions.assertThrows(OperationNotSupportedException.class, () -> calculatorNew.calc(5,5,"%"));
    }
}