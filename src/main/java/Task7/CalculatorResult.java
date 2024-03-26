package Task7;

import Exceptions.InvalidOperationException;

public abstract class CalculatorResult{
    private CalculatorRequest calculatorRequest;
    protected CalculatorResult(CalculatorRequest calculatorRequest){
        this.calculatorRequest = calculatorRequest;
    }

    public CalculatorRequest getRequest(){
        return calculatorRequest;
    }

    public abstract Object computeResult() throws InvalidOperationException;
}
