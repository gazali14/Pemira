package pemira.Model;

import pemira.Database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class VoterInfoModel {

    public boolean vote(String name, String nim, int age, String tingkat, String kelas, String email, String candidate, String username) {
        if (name == null || name.isEmpty() ||
            nim == null || nim.isEmpty() ||
            age <= 0 ||
            tingkat == null || tingkat.isEmpty() ||
            kelas == null || kelas.isEmpty() ||
            email == null || email.isEmpty() ||
            candidate == null || candidate.isEmpty() ||
            username == null || username.isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "All fields must be filled out and age must be greater than 0.");
            return false;
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO voter (name, nim, age, tingkat, kelas, email, candidate) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2, nim);
            pstmt.setInt(3, age);
            pstmt.setString(4, tingkat);
            pstmt.setString(5, kelas);
            pstmt.setString(6, email);
            pstmt.setString(7, candidate);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

        return updateHasVotedStatus(username);
    }

    private boolean updateHasVotedStatus(String username) {
        if (username == null || username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username cannot be empty.");
            return false;
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE users SET hasVoted = TRUE WHERE username = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

        return true;
    }
}
