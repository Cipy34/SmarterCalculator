package Exceptions;

import Task7.CalculatorRequest;

public class CalculatorException extends Exception{
    public CalculatorException(String msg){
        super(msg);
    }
}
