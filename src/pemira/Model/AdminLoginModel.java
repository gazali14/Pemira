package pemira.Model;

/**
 *
 * @author Gazali
 */

import pemira.Database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLoginModel {

    public boolean authenticate(String username, String password) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM admin WHERE username=? AND password=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            
            boolean isAuthenticated = rs.next();
            return isAuthenticated;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}