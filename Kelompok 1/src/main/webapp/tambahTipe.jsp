<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tambah Tipe Mesin</title>
</head>
<body>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>
<%@ page import="java.util.ArrayList" %>

	<%
		
		if(request.getParameter("tambahtipe") != null){
			String Tipe_ID = request.getParameter("Tipe_ID");
			TipeModel tipeModel = new TipeModel();
			String Tipe_Mobil = request.getParameter("Tipe_Mobil");
			tipeModel.tambahTipe(Tipe_ID,Tipe_Mobil);
			out.print("<script>location.href='./tableTipe.jsp'</script>");
		}
		Mesin mesin = new Mesin();

	%>
	<form>
	Tipe_ID<input type="text" name="Tipe_ID" value=""> <br>
	Tipe_Mobil<input type="text" name="Tipe_Mobil" value=""> <br>
	<input name="tambahtipe" value ="Tambah" type="submit"> 
	</form>
</body>
</html>