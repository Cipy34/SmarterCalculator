package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public final class DataBaseCommands {
    private static int id;
    private final Connection connection;

    public DataBaseCommands(Connection connection) {
        this.connection = connection;
    }

    public void insert(String type, String leftOperand, String operation, String rightOperand, String result) throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO \"smartercalculatorresults\" VALUES (?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setInt(1, id++);
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, String.valueOf(leftOperand));
            preparedStatement.setString(5, String.valueOf(operation));
            preparedStatement.setString(4, String.valueOf(rightOperand));
            preparedStatement.setString(6, result);
            preparedStatement.executeUpdate();
        }
    }

    public void delete() throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM \"smartercalculatorresults\"")) {
            preparedStatement.executeUpdate();
        }
    }

    public void citire() throws SQLException{
        String query = "SELECT * FROM \"smartercalculatorresults\"";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("operation_type") + ": " + resultSet.getString("left_operand") + resultSet.getString("operation") + resultSet.getString("right_operand") + " = " + resultSet.getString("result"));
            }
        }
    }

    public void deleteWhere(String operationType) throws SQLException {
        String sql = "DELETE FROM \"smartercalculatorresults\" WHERE \"operation_type\" = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, operationType); // Set the operationType parameter
            preparedStatement.executeUpdate();
        }
    }

    public void deleteWhere2(int id) throws  SQLException{
        String deleteQuery = "DELETE FROM smartercalculatorresults " +
                "WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public void deleteDuplicates() throws SQLException {
        String query = "SELECT * FROM \"smartercalculatorresults\"";
        Set<String> duplicatesRecord = new HashSet<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String operationType = resultSet.getString("operation_type");
                String leftOperand = resultSet.getString("left_operand");
                String rightOperand = resultSet.getString("right_operand");
                String operation = resultSet.getString("operation");
                String result = resultSet.getString("result");

                String key = operationType + leftOperand + rightOperand + operation + result;
                if(duplicatesRecord.contains(key)){
                    deleteWhere2(id);
                } else{
                    duplicatesRecord.add(key);
                }
            }
        }
    }
}
