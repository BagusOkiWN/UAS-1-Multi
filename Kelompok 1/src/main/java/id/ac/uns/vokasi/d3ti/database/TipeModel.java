package id.ac.uns.vokasi.d3ti.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class TipeModel {
	Connection con;
    Statement st;
    ResultSet rs;
    ArrayList<Tipe> listTipe;

    public TipeModel() {
        try {
            String url = "jdbc:mysql://127.0.0.1/universitas?user=root&password=";
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url);
            listTipe = new ArrayList<>(); 
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Tipe> getAlldata() {
        String query = "SELECT * FROM mesin";
        try {
            st = (Statement) con.createStatement();
            rs = (ResultSet) st.executeQuery(query);
            listTipe.clear(); 
            while (rs.next()) {
                Tipe tipe = new Tipe();
                tipe.setTipe_ID(rs.getInt(1));
                tipe.setTipe(rs.getString(2));
                listTipe.add(tipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTipe;
    }
}