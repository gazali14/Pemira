package pemira.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class VoterInfoModel {

    public void vote(String name, String nim, int age, String tingkat, String kelas, String email, String candidate, String username) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pemira", "root", "");

            String sql = "INSERT INTO voter VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2, nim);
            pstmt.setInt(3, age);
            pstmt.setString(4, tingkat);
            pstmt.setString(5, kelas);
            pstmt.setString(6, email);
            pstmt.setString(7, candidate);
            pstmt.executeUpdate();

            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        updateHasVotedStatus(username);
    }

    private void updateHasVotedStatus(String username) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pemira", "root", "");
            String sql = "UPDATE users SET hasVoted = TRUE WHERE username = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.executeUpdate();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
