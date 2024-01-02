package id.ac.uns.vokasi.d3ti.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class CarsModel {
	Connection con;
    Statement st;
    ResultSet rs;
    ArrayList<Cars> listCars;

    public CarsModel() {
        try {
            String url = "jdbc:mysql://127.0.0.1/universitas?user=root&password=";
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url);
            listCars = new ArrayList<>(); 
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Cars> getAlldata() {
        String query = "SELECT * FROM car";
        try {
            st = (Statement) con.createStatement();
            rs = (ResultSet) st.executeQuery(query);
            listCars.clear(); 
            while (rs.next()) {
                Cars cars = new Cars();
                cars.setRegistrasi(rs.getString(1));
                cars.setNama(rs.getString(2));
                cars.setWarna(rs.getString(3));
                cars.setTahun(rs.getString(4));
                cars.setCc(rs.getString(5));
                cars.setPower(rs.getString(6));
                cars.setHarga(rs.getString(7));
                
                listCars.add(cars);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCars;
    }
    
    public void updateMobil(String registrasi, String nama, String warna, String tahun, String power, String harga) {
        String query = "UPDATE car SET nama='" + nama + "', warna='" + warna + "', tahun='" + tahun + "', power='" + power + "', harga='" + harga + "' WHERE registrasi='" + registrasi + "'";
        try {
            st = con.createStatement();
            int rowsAffected = st.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Data updated successfully!");
            } else {
                System.out.println("Failed to update data. No matching record found for registrasi: " + registrasi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
