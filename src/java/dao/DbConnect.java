package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

    private static final String pass = "jdbc:mysql://localhost/projectDrMalhat";
    private static final String name = "root";
    private static final String password = "";

    public static Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return (Connection) DriverManager.getConnection(pass, name, password);
    }
}
