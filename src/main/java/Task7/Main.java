package Task7;
import Exceptions.InvalidOperationException;
import Exceptions.UnkownOperandTypeException;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void foo(String[] args) throws UnkownOperandTypeException, InvalidOperationException {
        List<CalculatorResult> calculationResults =  SmarterCalculator.calculate(args);

        for (CalculatorResult result : calculationResults) {
            CalculatorRequest request = result.getRequest();
            System.out.println("Operation " + request + " has result " + result.computeResult());
        }
    }

    public static void main(String[] args) throws UnkownOperandTypeException, InvalidOperationException {

        foo(new String[]{"1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1",
                "true", "||", "false",
                "true", "&&", "true",
                "1.0", "*", "10",
                "1", "&&", "0",
                "true", "+", "0",
                "-10.2", "+", "0.2",
                /*"ab.c", "+", "1"*/});
    }
}
