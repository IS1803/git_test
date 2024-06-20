package com.mycompany.isp392.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
    private static final String DB_NAME = "ecomerce";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASS = "Abc123@$";
    private static final String moreva = "abcxyz";
    

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=" + DB_NAME + ";encrypt=true;trustServerCertificate=true";
        conn = DriverManager.getConnection(url, DB_USERNAME, DB_PASS);
        return conn;
    }

    public static void main(String[] args) {
        // Test connection
        try {
            Connection conn = DbUtils.getConnection();
            if (conn != null) {
                System.out.println("Connected");
            } else {
                System.out.println("Failed");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
