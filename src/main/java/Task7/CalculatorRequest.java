package Task7;

import javax.print.attribute.standard.JobKOctets;

public class CalculatorRequest {
    private Object leftOperand;
    private Object rightOperand;
    private String operation;

    public Object getLeftOperand(){
        return this.leftOperand;
    }

    public Object getRightOperand(){
        return this.rightOperand;
    }

    public String getOperation(){
        return this.operation;
    }

    public CalculatorRequest(Object leftOperand, Object rightOperand, String operation){
        this.leftOperand = leftOperand;
        this.operation = operation;
        this.rightOperand = rightOperand;
    }

    public String getRequestType(){
        if(leftOperand instanceof Boolean){
            if(rightOperand instanceof Boolean)
                return "Boolean";
            return "Invalid";
        }

        if(rightOperand instanceof Boolean){
            if(leftOperand instanceof Boolean)
                return "Boolean";
            return "Invalid";
        }

        if(leftOperand instanceof Integer && rightOperand instanceof Integer)
            return "Integer";

        if(leftOperand instanceof Double || rightOperand instanceof Double)
            return "Double";

        return "Invalid";
    }

    @Override
    public String toString(){
        return leftOperand + " " + operation + " " + rightOperand;
    }
}
