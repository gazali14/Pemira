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

public class VoterOptionsModel {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pemira";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public boolean hasUserAlreadyVoted(String username) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        String sql = "SELECT hasVoted FROM users WHERE username = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();
        boolean hasVoted = rs.next() && rs.getBoolean("hasVoted");
        conn.close();
        return hasVoted;
    }
}
