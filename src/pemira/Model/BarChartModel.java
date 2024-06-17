package pemira.Model;

/**
 *
 * @author Gazali
 */

import pemira.Database.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;

public class BarChartModel {
    private LinkedHashMap<String, Integer> dataHashMap;

    public BarChartModel() {
        dataHashMap = new LinkedHashMap<>();
    }

    public LinkedHashMap<String, Integer> fetchData() throws SQLException {
        int SEL1_QTY = 0, SEL2_QTY = 0;

        try (Connection conn = DatabaseConnection.getConnection()) {
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
        }

        dataHashMap.clear();
        dataHashMap.put("Paslon 1", SEL1_QTY);
        dataHashMap.put("Paslon 2", SEL2_QTY);

        return dataHashMap;
    }
}
