package pemira.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class BarChartModel {
    private HashMap<String, Integer> dataHashMap;

    public BarChartModel() {
        dataHashMap = new HashMap<>();
    }

    public HashMap<String, Integer> fetchData() throws ClassNotFoundException, SQLException {
        int SEL1_QTY = 0, SEL2_QTY = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pemira", "root", "");

        String sql = "SELECT candidate FROM voter";
        Statement st = conn.createStatement();
        ResultSet rset = st.executeQuery(sql);
        while (rset.next()) {
            String cand = rset.getString("candidate");
            if ("Paslon 1".equalsIgnoreCase(cand)) {
                SEL1_QTY++;
            } else if ("Paslon 2".equalsIgnoreCase(cand)) {
                SEL2_QTY++;
            }
        }

        dataHashMap.clear();
        dataHashMap.put("Paslon 1", SEL1_QTY);
        dataHashMap.put("Paslon 2", SEL2_QTY);

        conn.close();
        return dataHashMap;
    }
}
