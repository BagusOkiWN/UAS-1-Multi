package id.ac.uns.vokasi.d3ti.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class TransmisiModel {
	Connection con;
    Statement st;
    ResultSet rs;
    ArrayList<Transmisi> listTransmisi;

    public TransmisiModel() {
        try {
            String url = "jdbc:mysql://127.0.0.1/universitas?user=root&password=";
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url);
            listTransmisi = new ArrayList<>(); 
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Transmisi> getAlldata() {
        String query = "SELECT * FROM transmisi";
        try {
            st = (Statement) con.createStatement();
            rs = (ResultSet) st.executeQuery(query);
            listTransmisi.clear(); 
            while (rs.next()) {
                Transmisi transmisi = new Transmisi();
                transmisi.setTransmisi_ID(rs.getInt(1));
                transmisi.setTransmisi(rs.getString(2));
                listTransmisi.add(transmisi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTransmisi;
    }
}