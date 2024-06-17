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
import javax.swing.JOptionPane;

public class VoterOptionsModel {

    public boolean hasUserAlreadyVoted(String username) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Query SQL untuk memeriksa status hasVoted dari username tertentu
            String sql = "SELECT hasVoted FROM users WHERE username = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                boolean hasVoted = rs.getBoolean("hasVoted");
                return hasVoted;
            } else {
                return false; // Return false jika tidak ada baris yang sesuai
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Koneksi database gagal: " + e.getMessage())    ;
        }
        return false;
    }
}