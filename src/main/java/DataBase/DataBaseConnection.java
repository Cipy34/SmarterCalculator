package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DataBaseConnection {
    private final String url;
    private final String username;
    private final String password;

    public DataBaseConnection(){
        this.url = "jdbc:postgresql://localhost:5432/SmarterCalculatorDB";
        this.password = "ciprian";
        this.username = "postgres";
    }

    public Connection connect(){
        try{
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e){
            throw new Error("Connection failure.");
        }
    }
}
