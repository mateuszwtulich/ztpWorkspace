package com.company.model;
import java.sql.*;

public abstract class DbConfig {
    private static Connection conn = null;

    public static Connection getConn() {
        return conn;
    }

    public static void connectToDb() {
        try {
            String url = "jdbc:mysql://localhost:3306/ztp?useTimezone=true&serverTimezone=GMT%2B8";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "admin", "nimda");
            System.out.println("\nDatabase connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void disconnectFromDb(){
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) { /* ignore close errors */ }
        }
    }
}
