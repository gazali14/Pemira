package Pemira.Model;

import pemira.Database.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ViewRecordsModel {

    public List<String[]> getVoterRecords() throws SQLException {
        List<String[]> records = new ArrayList<>();

        try (Connection con = DatabaseConnection.getConnection()) {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM voter";
            ResultSet rst = st.executeQuery(sql);

            while (rst.next()) {
                String[] record = {
                    rst.getString("NIM"),
                    rst.getString("name"),
                    String.valueOf(rst.getInt("age")),
                    rst.getString("tingkat"),
                    rst.getString("kelas"),
                    rst.getString("email"),
                    rst.getString("candidate")
                };
                records.add(record);
            }
        }

        return records;
    }
}