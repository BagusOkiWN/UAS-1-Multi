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
        String query = "SELECT * FROM tipe";
        try {
            st = (Statement) con.createStatement();
            rs = (ResultSet) st.executeQuery(query);
            listTipe.clear(); 
            while (rs.next()) {
                Tipe tipe = new Tipe();
                tipe.setTipe_ID(rs.getString(1));
                tipe.setTipe_Mobil(rs.getString(2));
                listTipe.add(tipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTipe;
    }
    
    public void updateTipe(String Tipe_ID, String Tipe_Mobil) {
        String query = "UPDATE tipe SET Tipe_Mobil='" + Tipe_Mobil + "' WHERE Tipe_ID='" + Tipe_ID + "'";
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
    
    public Tipe getTipeByID(String idToSearch) {
        String query = "SELECT * FROM tipe WHERE Tipe_ID=?";
        Tipe tipe = null;

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, idToSearch);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tipe = new Tipe();
                tipe.setTipe_ID(rs.getString("Tipe_ID"));
                tipe.setTipe_Mobil(rs.getString("Tipe_Mobil"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tipe;
    }
    
    public void hapusTipe (String Tipe_ID) {
		String query="DELETE FROM tipe WHERE Tipe_ID = '"+Tipe_ID+"'";
		try {
			st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void tambahTipe(String Tipe_ID, String Tipe_Mobil) {
        String query = "INSERT INTO tipe (Tipe_ID, Tipe_Mobil) VALUES ('" + Tipe_ID + "', '" + Tipe_Mobil + "')";
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