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
                transmisi.setTransmisi_ID(rs.getString(1));
                transmisi.setTransmisi_Mobil(rs.getString(2));
                listTransmisi.add(transmisi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTransmisi;
    }
    
    public void updateTransmisi(String Transmisi_ID, String Transmisi_Mobil) {
        String query = "UPDATE transmisi SET Transmisi_Mobil='" + Transmisi_Mobil + "' WHERE Transmisi_ID='" + Transmisi_ID + "'";
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
    
    public Transmisi getTransmisiByID(String idToSearch) {
        String query = "SELECT * FROM transmisi WHERE Transmisi_ID=?";
        Transmisi transmisi = null;

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, idToSearch);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                transmisi = new Transmisi();
                transmisi.setTransmisi_ID(rs.getString("Transmisi_ID"));
                transmisi.setTransmisi_Mobil(rs.getString("Transmisi_Mobil"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transmisi;
    }
    
    public void hapusTransmisi (String Transmisi_ID) {
		String query="DELETE FROM transmisi WHERE Transmisi_ID = '"+Transmisi_ID+"'";
		try {
			st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void tambahTransmisi(String Transmisi_ID, String Transmisi_Mobil) {
        String query = "INSERT INTO transmisi (Transmisi_ID, Transmisi_Mobil) VALUES ('" + Transmisi_ID + "', '" + Transmisi_Mobil + "')";
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