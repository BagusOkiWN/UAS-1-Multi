package id.ac.uns.vokasi.d3ti.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class MahasiswaModel {
    Connection con;
    Statement st;
    ResultSet rs;
    ArrayList<Mahasiswa> listMahasiswa;

    public MahasiswaModel() {
        try {
            String url = "jdbc:mysql://127.0.0.1/universitas?user=root&password=";
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url);
            listMahasiswa = new ArrayList<>(); 
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Mahasiswa> getAlldata() {
        String query = "SELECT * FROM mahasiswa";
        try {
            st = (Statement) con.createStatement();
            rs = (ResultSet) st.executeQuery(query);
            listMahasiswa.clear(); 
            while (rs.next()) {
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setNim(rs.getString(1));
                mahasiswa.setNama(rs.getString(2));
                mahasiswa.setAlamat(rs.getString(3));
                listMahasiswa.add(mahasiswa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMahasiswa;
    }

    public void ubahNama(String nim, String nama) {
        String query = "UPDATE mahasiswa SET nama='" + nama + "' WHERE nim='" + nim + "'";
        try {
            st = con.createStatement();
            int rowsAffected = st.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Data updated successfully!");
            } else {
                System.out.println("Failed to update data. No matching record found for nim: " + nim);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateAlamat(String nim, String alamat) {
        String query = "UPDATE mahasiswa SET alamat='" + alamat + "' WHERE nim='" + nim + "'";
        try {
            st = con.createStatement();
            int rowsAffected = st.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Data updated successfully!");
            } else {
                System.out.println("Failed to update data. No matching record found for nim: " + nim);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public Mahasiswa getMahasiswaByNim(String nimToSearch) {
        String query = "SELECT * FROM mahasiswa WHERE nim=?";
        Mahasiswa mahasiswa = null;

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, nimToSearch);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                mahasiswa = new Mahasiswa();
                mahasiswa.setNim(rs.getString("nim"));
                mahasiswa.setNama(rs.getString("nama"));
                mahasiswa.setAlamat(rs.getString("alamat"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mahasiswa;
    }

    
    public void tambahMahasiswa(String nim, String nama, String alamat) {
        String query = "INSERT INTO mahasiswa (nim, nama, alamat) VALUES ('" + nim + "', '" + nama + "', '" + alamat + "')";
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
    
    public void updateTable(DefaultTableModel model) {
        ArrayList<Mahasiswa> listMahasiswa = getAlldata();
        model.setRowCount(0); 

        for (Mahasiswa mahasiswa : listMahasiswa) {
            Object[] row = {mahasiswa.getNim(), mahasiswa.getNama(), mahasiswa.getAlamat()};
            model.addRow(row);
        }
    }
    
    
}
