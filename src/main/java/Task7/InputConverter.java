package Task7;


import Exceptions.InvalidArgumentsLengthException;
import Exceptions.InvalidOperationException;
import Exceptions.UnkownOperandTypeException;

import java.util.ArrayList;
import java.util.List;

public class InputConverter {
    public static List<CalculatorRequest> mapRequests(String[] args) throws UnkownOperandTypeException {
        if(args.length < 3)
            throw new InvalidArgumentsLengthException("Prea putine argumente!");

        List<CalculatorRequest> l = new ArrayList<>();
        Object leftOperand = null;
        Object rightOperand = null;
        String operand;

        if(args[0].equals("true") || args[0].equals("false") &&
                args[2].equals("true") || args[2].equals("false")){
            leftOperand = Boolean.parseBoolean(args[0]);
            rightOperand = Boolean.parseBoolean(args[2]);
        }

        if(args[0].contains(".") || args[2].contains(".")){
            try{
                leftOperand = Double.parseDouble(args[0]);
                rightOperand = Double.parseDouble(args[2]);
            }
            catch (NumberFormatException e){
                throw new UnkownOperandTypeException("Nu exista acest operand");
            }
        }

        if(leftOperand == null){
            try{
                leftOperand = Integer.parseInt(args[0]);
                rightOperand = Integer.parseInt(args[2]);
            }
            catch(NumberFormatException e){
                throw new UnkownOperandTypeException("Nu exista acest operand");
            }
        }

        operand = args[1];
        CalculatorRequest request = new CalculatorRequest(leftOperand, rightOperand, operand);
        l.add(request);

        return l;
    }
}
