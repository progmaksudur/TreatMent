package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection databaselink;

    public  Connection getConnection() throws SQLException {

        String URL = "jdbc:mysql://localhost:3306/hospital";
        String USER = "root";
        String PASS = "";
        Connection databaselink = DriverManager.getConnection(URL, USER, PASS);
        System.out.println("Succesfully Connect");

        return databaselink;

    }
}
