<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tambah Mobil</title>
</head>
<body>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>
<%@ page import="java.util.ArrayList" %>

	<%
		
		if(request.getParameter("tambahmobil") != null){
			String Merk_ID = request.getParameter("Merk_ID");
			MobilModel mobilModel = new MobilModel();
			String Merk_Mobil = request.getParameter("Merk_Mobil");
			// Additional parameters for Tipe, Warna, Mesin, Transmisi, Harga
			String Tipe_Mobil = request.getParameter("Tipe_Mobil");
			String Warna_Mobil = request.getParameter("Warna_Mobil");
			String Mesin = request.getParameter("Mesin");
			String Transmisi_Mobil = request.getParameter("Transmisi_Mobil");
			int Harga = Integer.parseInt(request.getParameter("Harga"));

			// Assuming that you have appropriate methods in MobilModel to add a new Mobil
			mobilModel.tambahMobil(Merk_ID, Merk_Mobil, Tipe_Mobil, Warna_Mobil, Mesin, Transmisi_Mobil, Harga);
			
			out.print("<script>location.href='./tableMobil.jsp'</script>");
		}

	%>
	<form>
	Merk_ID<input type="text" name="Merk_ID" value=""> <br>
	Merk_Mobil<input type="text" name="Merk_Mobil" value=""> <br>
	Tipe_Mobil<input type="text" name="Tipe_Mobil" value=""> <br>
	Warna_Mobil<input type="text" name="Warna_Mobil" value=""> <br>
	Mesin<input type="text" name="Mesin" value=""> <br>
	Transmisi_Mobil<input type="text" name="Transmisi_Mobil" value=""> <br>
	Harga<input type="text" name="Harga" value=""> <br>
	<input name="tambahmobil" value ="Tambah" type="submit"> 
	</form>
</body>
</html>
