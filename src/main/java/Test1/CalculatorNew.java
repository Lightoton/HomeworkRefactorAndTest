package Test1;

import javax.naming.OperationNotSupportedException;

// Нарушение KISS:
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }

}

public class CalculatorNew {
    public int calc(int a, int b, String operation) throws OperationNotSupportedException {
        switch (operation) {
            case "+" -> {
                return a + b;
            }
            case "-" -> {
                return a - b;
            }
            case "*" -> {
                return a * b;
            }
            case "/" -> {
                if (b != 0) {
                    return a / b;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            }
            default -> throw new  OperationNotSupportedException("This operation is not supported!");
        }
    }
}
