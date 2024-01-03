package id.ac.uns.vokasi.d3ti.database;

public class Mobil {
	int Mobil_ID;
	String Merk;
	String Tipe;
	String Warna;
	String Mesin;
	String Transmisi;
	int Harga;
	public int getMobil_ID() {
		return Mobil_ID;
	}
	public void setMobil_ID(int mobil_ID) {
		Mobil_ID = mobil_ID;
	}
	public String getMerk() {
		return Merk;
	}
	public void setMerk(String merk) {
		Merk = merk;
	}
	public String getTipe() {
		return Tipe;
	}
	public void setTipe(String tipe) {
		Tipe = tipe;
	}
	public String getWarna() {
		return Warna;
	}
	public void setWarna(String warna) {
		Warna = warna;
	}
	public String getMesin() {
		return Mesin;
	}
	public void setMesin(String mesin) {
		Mesin = mesin;
	}
	public String getTransmisi() {
		return Transmisi;
	}
	public void setTransmisi(String transmisi) {
		Transmisi = transmisi;
	}
	public int getHarga() {
		return Harga;
	}
	public void setHarga(int harga) {
		Harga = harga;
	}
}
