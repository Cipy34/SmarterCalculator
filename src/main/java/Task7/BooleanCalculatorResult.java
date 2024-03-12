package Task7;

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
    public Boolean computeResult() {
        switch (o){
            case "&&":
                return (Boolean) l && (Boolean) r;
            case "||":
                return (Boolean) l || (Boolean) r;
        }
        return null;
    }
}
