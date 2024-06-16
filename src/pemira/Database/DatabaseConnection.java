/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pemira.Database;

/**
 *
 * @author U53R
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Utility class for managing database connection to SQLite.
 */
public class DatabaseConnection {
    private static Connection con = null;
    private static final String DATABASE_URL = "jdbc:sqlite:C:/Users/U53R/Documents/SQLite/pemira.db";

    /**
     * Get the database connection.
     * @return Connection object representing the database connection.
     */
    public static Connection getConnection() {
        try {
            // Load SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");
            
            // Create connection to database
            con = DriverManager.getConnection(DATABASE_URL);
            
            // Set busy timeout (optional)
            try (Statement stmt = con.createStatement()) {
                stmt.execute("PRAGMA busy_timeout = 5000"); // 5000 ms timeout
            }
            
            System.out.println("Successfully connected to SQLite database.");
            
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC driver not found: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to create connection to SQLite: " + e.getMessage());
            e.printStackTrace();
        }
        
        return con;
    }
}
