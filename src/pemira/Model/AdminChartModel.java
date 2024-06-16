/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pemira.Model;

/**
 *
 * @author U53R
 */


import pemira.Database.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class AdminChartModel {
    private LinkedHashMap<String, Integer> dataHashMap;

    public AdminChartModel() {
        dataHashMap = new LinkedHashMap<>();
    }

    public HashMap<String, Integer> fetchData() throws SQLException {
        int SEL1_QTY = 0, SEL2_QTY = 0;
        ArrayList<User> usersList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT candidate FROM voter";
            Statement st = conn.createStatement();
            ResultSet rset = st.executeQuery(sql);

            while (rset.next()) {
                User user = new User(rset.getString("candidate"));
                usersList.add(user);
                String cand = user.getcandidate();
                if (cand.equalsIgnoreCase("Paslon 1")) {
                    ++SEL1_QTY;
                }
                if (cand.equalsIgnoreCase("Paslon 2")) {
                    ++SEL2_QTY;
                }
            }
        }

        dataHashMap.clear();
        dataHashMap.put("Paslon 1", SEL1_QTY);
        dataHashMap.put("Paslon 2", SEL2_QTY);

        return dataHashMap;
    }
}
