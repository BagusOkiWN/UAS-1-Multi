package id.ac.uns.vokasi.d3ti.database;

import java.util.ArrayList;

public class MainData {
	
	public static void main(String args[]) {
		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		ArrayList<Mahasiswa> mahasiswaList=new ArrayList<>();
		mahasiswaList.addAll (mahasiswaModel.getAlldata());
		System.out.println(mahasiswaList.get(1).getNim());
		
	}
}
