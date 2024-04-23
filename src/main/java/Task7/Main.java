package Task7;
import DataBase.DataBaseCommands;
import DataBase.DataBaseConnection;
import Exceptions.InvalidOperationException;
import Exceptions.UnkownOperandTypeException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void foo(String[] args) throws UnkownOperandTypeException, InvalidOperationException, SQLException {
        Connection connection = new DataBaseConnection().connect();
        List<CalculatorResult> calculationResults =  SmarterCalculator.calculate(args);
        DataBaseCommands dbc = new DataBaseCommands(connection);
        dbc.delete();
        for (CalculatorResult result : calculationResults) {
            CalculatorRequest request = result.getRequest();
            System.out.println("Operation " + request + " has result " + result.computeResult());
            dbc.insert(request.getRequestType(), Objects.toString(request.getLeftOperand()), Objects.toString(request.getOperation()), Objects.toString(request.getRightOperand()), Objects.toString(result.computeResult()));
            System.out.println(Objects.toString(request.getOperation()));
        }
        connection.close();
    }

    public static void main(String[] args) throws UnkownOperandTypeException, InvalidOperationException, SQLException {

        foo(new String[]{"1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "1.0", "-", "2",
                "10.0", "/", "1",
                "true", "||", "false",
                "true", "&&", "true",
                "1.0", "*", "10",
                /*"1", "&&", "0",
                "true", "+", "0",
                "-10.2", "+", "0.2",
                "ab.c", "+", "1"*/});

//        Table table = new Table();
//        table.create_smarterCalculatorResults(connection);

        Connection connection = new DataBaseConnection().connect();
        DataBaseCommands dbc = new DataBaseCommands(connection);

        //dbc.citire();
//        dbc.deleteWhere("Double");
        dbc.deleteDuplicates();
        dbc.citire();
        connection.close();
    }
}
