package Task7;

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
    public Integer computeResult() {
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
        return null;
    }
}
