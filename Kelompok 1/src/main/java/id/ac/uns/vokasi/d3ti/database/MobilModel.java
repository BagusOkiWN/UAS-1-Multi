package id.ac.uns.vokasi.d3ti.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MobilModel {
    Connection con;
    Statement st;
    ResultSet rs;
    ArrayList<Mobil> listMobil;

    public MobilModel() {
        try {
            String url = "jdbc:mysql://127.0.0.1/universitas?user=root&password=";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url);
            listMobil = new ArrayList<>();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Mobil> getAlldata() {
        String query = "SELECT m.*, t.Tipe_Mobil, w.Warna_Mobil, me.Mesin, tr.Transmisi_Mobil " +
                "FROM mobil m " +
                "JOIN tipe t ON m.Tipe_ID = t.Tipe_ID " +
                "JOIN warna w ON m.Warna_ID = w.Warna_ID " +
                "JOIN mesin me ON m.Mesin_ID = me.Mesin_ID " +
                "JOIN transmisi tr ON m.Transmisi_ID = tr.Transmisi_ID";

        try {
            st = (Statement) con.createStatement();
            rs = (ResultSet) st.executeQuery(query);
            listMobil.clear();

            while (rs.next()) {
                Mobil mobil = new Mobil();
                mobil.setMobil_ID(rs.getInt("Mobil_ID"));
                mobil.setMerk(rs.getString("Merk_Mobil"));
                mobil.setTipe(rs.getString("Tipe_Mobil"));
                mobil.setWarna(rs.getString("Warna_Mobil"));
                mobil.setMesin(rs.getString("Mesin"));
                mobil.setTransmisi(rs.getString("Transmisi_Mobil"));
                mobil.setHarga(rs.getInt("Harga"));
                listMobil.add(mobil);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMobil;
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

    public void hapusMerk(String Merk_ID) {
        String query = "DELETE FROM merk WHERE Merk_ID = '" + Merk_ID + "'";
        try {
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get data for the Tipe dropdown
    public ArrayList<Tipe> getTipeData() {
        ArrayList<Tipe> listTipe = new ArrayList<>();

        try {
            String query = "SELECT * FROM tipe";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Tipe tipe = new Tipe();
                tipe.setTipe_ID(rs.getInt("Tipe_ID"));
                tipe.setTipe_Mobil(rs.getString("Tipe_Mobil"));
                listTipe.add(tipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listTipe;
    }

    // Method to get data for the Warna dropdown
    public ArrayList<Warna> getWarnaData() {
        ArrayList<Warna> listWarna = new ArrayList<>();

        try {
            String query = "SELECT * FROM warna";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Warna warna = new Warna();
                warna.setWarna_ID(rs.getInt("Warna_ID"));
                warna.setWarna_Mobil(rs.getString("Warna_Mobil"));
                listWarna.add(warna);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listWarna;
    }

    // Method to get data for the Mesin dropdown
    public ArrayList<Mesin> getMesinData() {
        ArrayList<Mesin> listMesin = new ArrayList<>();

        try {
            String query = "SELECT * FROM mesin";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Mesin mesin = new Mesin();
                mesin.setMesin_ID(rs.getInt("Mesin_ID"));
                mesin.setMesin(rs.getString("Mesin"));
                listMesin.add(mesin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listMesin;
    }

    // Method to get data for the Transmisi dropdown
    public ArrayList<Transmisi> getTransmisiData() {
        ArrayList<Transmisi> listTransmisi = new ArrayList<>();

        try {
            String query = "SELECT * FROM transmisi";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Transmisi transmisi = new Transmisi();
                transmisi.setTransmisi_ID(rs.getInt("Transmisi_ID"));
                transmisi.setTransmisi_Mobil(rs.getString("Transmisi_Mobil"));
                listTransmisi.add(transmisi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listTransmisi;
    }

    // Method to add new Mobil with dropdown values
    public void tambahMobil(String Merk_ID, String Merk_Mobil, String Tipe_Mobil, String Warna_Mobil, String Mesin, String Transmisi_Mobil, int Harga) {
        String insertQuery = "INSERT INTO mobil (Merk_ID, Merk_Mobil, Tipe_ID, Warna_ID, Mesin_ID, Transmisi_ID, Harga) " +
                "VALUES (?, ?, (SELECT Tipe_ID FROM tipe WHERE Tipe_Mobil = ?), " +
                "(SELECT Warna_ID FROM warna WHERE Warna_Mobil = ?), " +
                "(SELECT Mesin_ID FROM mesin WHERE Mesin = ?), " +
                "(SELECT Transmisi_ID FROM transmisi WHERE Transmisi_Mobil = ?), ?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, Merk_ID);
            preparedStatement.setString(2, Merk_Mobil);
            preparedStatement.setString(3, Tipe_Mobil);
            preparedStatement.setString(4, Warna_Mobil);
            preparedStatement.setString(5, Mesin);
            preparedStatement.setString(6, Transmisi_Mobil);
            preparedStatement.setInt(7, Harga);

            int rowsAffected = preparedStatement.executeUpdate();
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
