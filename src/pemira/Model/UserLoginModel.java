/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pemira.Model;

/**
 *
 * @author U53R
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginModel {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pemira";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public boolean authenticate(String username, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();

        boolean isAuthenticated = rs.next();
        conn.close();
        return isAuthenticated;
    }
}
