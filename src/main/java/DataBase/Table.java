package DataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public final class Table {
    public void create_smarterCalculatorResults(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String createTable = """
        CREATE TABLE IF NOT EXISTS smarterCalculatorResults (
            id SERIAL PRIMARY KEY,
            operation_type VARCHAR(20) NOT NULL,
            left_operand VARCHAR(254) NOT NULL,
            right_operand VARCHAR(254) NOT NULL,
            operation VARCHAR(2) NOT NULL,
            result VARCHAR(255) NOT NULL
        )
        """;
        statement.execute(createTable);
    }
}
