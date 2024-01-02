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
                warna.setWarna_ID(rs.getString(1));
                warna.setWarna_Mobil(rs.getString(2));
                listWarna.add(warna);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listWarna;
    }
    
    public void updateWarna(String Warna_ID, String Warna_Mobil) {
        String query = "UPDATE warna SET Warna_Mobil='" + Warna_Mobil + "' WHERE Warna_ID='" + Warna_ID + "'";
        try {
            st = con.createStatement();
            int rowsAffected = st.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Data updated successfully!");
            } else {
                System.out.println("Failed to update data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Warna getWarnaByID(String idToSearch) {
        String query = "SELECT * FROM warna WHERE Warna_ID=?";
        Warna warna = null;

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, idToSearch);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                warna = new Warna();
                warna.setWarna_ID(rs.getString("Warna_ID"));
                warna.setWarna_Mobil(rs.getString("Warna_Mobil"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return warna;
    }
    
    public void hapusWarna (String Warna_ID) {
		String query="DELETE FROM warna WHERE Warna_ID = '"+Warna_ID+"'";
		try {
			st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void tambahWarna(String Warna_ID, String Warna_Mobil) {
        String query = "INSERT INTO warna (Warna_ID, Warna_Mobil) VALUES ('" + Warna_ID + "', '" + Warna_Mobil + "')";
        try {
            st = con.createStatement();
            int rowsAffected = st.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("Failed to insert data.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}