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
                mesin.setMesin_ID(rs.getString(1));
                mesin.setMesin(rs.getString(2));
                listMesin.add(mesin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMesin;
    }
    
    public void updateMesin(String Mesin_ID, String Mesin) {
        String query = "UPDATE mesin SET Mesin='" + Mesin + "' WHERE Mesin_ID='" + Mesin_ID + "'";
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
    
    public Mesin getMesinkByID(String idToSearch) {
        String query = "SELECT * FROM mesin WHERE Mesin_ID=?";
        Mesin mesin = null;

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, idToSearch);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                mesin = new Mesin();
                mesin.setMesin_ID(rs.getString("Mesin_ID"));
                mesin.setMesin(rs.getString("Mesin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mesin;
    }
    
    public void hapusMesin (String Mesin_ID) {
		String query="DELETE FROM mesin WHERE Mesin_ID = '"+Mesin_ID+"'";
		try {
			st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void tambahMesin(String Mesin_ID, String Mesin) {
        String query = "INSERT INTO mesin (Mesin_ID, Mesin) VALUES ('" + Mesin_ID + "', '" + Mesin + "')";
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