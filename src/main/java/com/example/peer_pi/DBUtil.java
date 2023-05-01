package com.example.peer_pi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/peer_pie_data";

    // Database credentials
    private static final String USER = "username";
    private static final String PASS = "password";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public static void closeConnection(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public static void closeStatement(Statement stmt) throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
    }

    public static void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
    }

    public static ResultSet dbExecuteQuery(String selectStmt) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(selectStmt);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error executing query: " + e.getMessage());
            throw e;
        } finally {
            closeStatement(stmt);
            closeConnection(conn);
        }

        return rs;
    }

    public static void dbExecuteUpdate(String updateStmt) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(updateStmt);
            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error executing update: " + e.getMessage());
            throw e;
        } finally {
            closeStatement(stmt);
            closeConnection(conn);
        }
    }
}

