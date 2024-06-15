package Pemira.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ViewRecordsModel {
    private final String DB_URL = "jdbc:mysql://localhost:3306/pemira";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "";

    public List<String[]> getVoterRecords() throws SQLException, ClassNotFoundException {
        List<String[]> records = new ArrayList<>();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
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

        con.close();
        return records;
    }
}
