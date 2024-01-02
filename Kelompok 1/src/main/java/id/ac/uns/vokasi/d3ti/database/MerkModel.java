package id.ac.uns.vokasi.d3ti.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class MerkModel {
	Connection con;
    Statement st;
    ResultSet rs;
    ArrayList<Merk> listMerk;

    public MerkModel() {
        try {
            String url = "jdbc:mysql://127.0.0.1/universitas?user=root&password=";
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url);
            listMerk = new ArrayList<>(); 
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Merk> getAlldata() {
        String query = "SELECT * FROM merk";
        try {
            st = (Statement) con.createStatement();
            rs = (ResultSet) st.executeQuery(query);
            listMerk.clear(); 
            while (rs.next()) {
                Merk merk = new Merk();
                merk.setMerk_ID(rs.getString(1));
                merk.setMerk_Mobil(rs.getString(2));
                listMerk.add(merk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMerk;
    }
    
    public void updateMerk(String Merk_ID, String Merk_Mobil) {
        String query = "UPDATE merk SET Merk_Mobil='" + Merk_Mobil + "' WHERE Merk_ID='" + Merk_ID + "'";
        try {
            st = con.createStatement();
            int rowsAffected = st.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Data updated successfully!");
            } else {
                System.out.println("Failed to update data. No matching record found for Merk_ID: " + Merk_ID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Merk getMerkByID(String idToSearch) {
        String query = "SELECT * FROM merk WHERE Merk_ID=?";
        Merk merk = null;

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, idToSearch);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                merk = new Merk();
                merk.setMerk_ID(rs.getString("Merk_ID"));
                merk.setMerk_Mobil(rs.getString("Merk_Mobil"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return merk;
    }


}