package Task7;

import Exceptions.InvalidOperationException;

public class BooleanCalculatorResult extends CalculatorResult{
    private Object l;
    private Object r;
    private String o;

    public BooleanCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
        l = calculatorRequest.getLeftOperand();
        r = calculatorRequest.getRightOperand();
        o = calculatorRequest.getOperation();
    }

    @Override
    public Boolean computeResult() throws InvalidOperationException {
        switch (o){
            case "&&":
                return (Boolean) l && (Boolean) r;
            case "||":
                return (Boolean) l || (Boolean) r;
        }
        throw new InvalidOperationException("Nu poti face aceasta operatie folosing acesti operanzi!");
    }
}
