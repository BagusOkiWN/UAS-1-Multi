package id.ac.uns.vokasi.d3ti.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class MesinModel {
	Connection con;
    Statement st;
    ResultSet rs;
    ArrayList<Mesin> listMesin;

    public MesinModel() {
        try {
            String url = "jdbc:mysql://127.0.0.1/universitas?user=root&password=";
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url);
            listMesin = new ArrayList<>(); 
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Mesin> getAlldata() {
        String query = "SELECT * FROM mesin";
        try {
            st = (Statement) con.createStatement();
            rs = (ResultSet) st.executeQuery(query);
            listMesin.clear(); 
            while (rs.next()) {
                Mesin mesin = new Mesin();
                mesin.setMesin_ID(rs.getInt(1));
                mesin.setMesin(rs.getString(2));
                listMesin.add(mesin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMesin;
    }
}