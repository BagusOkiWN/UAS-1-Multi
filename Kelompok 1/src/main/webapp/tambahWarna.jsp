<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tambah Warna</title>
</head>
<body>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>
<%@ page import="java.util.ArrayList" %>

	<%
		
		if(request.getParameter("tambahwarna") != null){
			String Warna_ID = request.getParameter("Warna_ID");
			WarnaModel warnaModel = new WarnaModel();
			String Warna_Mobil = request.getParameter("Warna_Mobil");
			warnaModel.tambahWarna(Warna_ID,Warna_Mobil);
			out.print("<script>location.href='./tableWarna.jsp'</script>");
		}
		Warna warna = new Warna();

	%>
	<form>
	Warna_ID<input type="text" name="Warna_ID" value=""> <br>
	Warna_Mobil<input type="text" name="Warna_Mobil" value=""> <br>
	<input name="tambahwarna" value ="Tambah" type="submit"> 
	</form>
</body>
</html>