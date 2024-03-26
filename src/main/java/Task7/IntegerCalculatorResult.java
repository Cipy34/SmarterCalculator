package Task7;

import Exceptions.InvalidOperationException;

public class IntegerCalculatorResult extends CalculatorResult{
    private Object l;
    private Object r;
    private String o;

    public IntegerCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
        l = calculatorRequest.getLeftOperand();
        r = calculatorRequest.getRightOperand();
        o = calculatorRequest.getOperation();
    }

    @Override
    public Integer computeResult() throws InvalidOperationException {
        switch (o){
            case "+":
                return (Integer) l + (Integer) r;
            case "-":
                return (Integer) l - (Integer) r;
            case "*":
                return (Integer) l * (Integer) r;
            case "/":
                return (Integer) l / (Integer) r;
        }
        throw new InvalidOperationException("Nu poti face aceasta operatie folosing acesti operanzi!");
    }
}
