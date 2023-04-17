package main;
import java.sql.*;

public class DB {
    public static Connection dblink;

    public static Connection getConnection() {
        String dbName = "slackers";
        String dbUser = "root";
        String dbPass = "";
        String url = "jdbc:mysql://localhost:3306/" + dbName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dblink = DriverManager.getConnection(url,dbUser,dbPass);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return dblink;
    }
}
