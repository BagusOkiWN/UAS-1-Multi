package id.ac.uns.vokasi.d3ti.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class WarnaModel {
	Connection con;
    Statement st;
    ResultSet rs;
    ArrayList<Warna> listWarna;

    public WarnaModel() {
        try {
            String url = "jdbc:mysql://127.0.0.1/universitas?user=root&password=";
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url);
            listWarna = new ArrayList<>(); 
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Warna> getAlldata() {
        String query = "SELECT * FROM warna";
        try {
            st = (Statement) con.createStatement();
            rs = (ResultSet) st.executeQuery(query);
            listWarna.clear(); 
            while (rs.next()) {
                Warna warna = new Warna();
                warna.setWarna_ID(rs.getInt(1));
                warna.setWarna_Mobil(rs.getString(2));
                listWarna.add(warna);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listWarna;
    }
}