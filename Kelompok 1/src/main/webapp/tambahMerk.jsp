<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tambah Merk</title>
</head>
<body>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>
<%@ page import="java.util.ArrayList" %>

	<%
		
		if(request.getParameter("tambahmerk") != null){
			String Merk_ID = request.getParameter("Merk_ID");
			MerkModel merkModel = new MerkModel();
			String Merk_Mobil = request.getParameter("Merk_Mobil");
			merkModel.tambahMerk(Merk_ID,Merk_Mobil);
			out.print("<script>location.href='./tableMerk.jsp'</script>");
		}
		Merk merk = new Merk();

	%>
	<form>
	Merk_ID<input type="text" name="Merk_ID" value=""> <br>
	Merk_Mobil<input type="text" name="Merk_Mobil" value=""> <br>
	<input name="tambahmerk" value ="Tambah" type="submit"> 
	</form>
</body>
</html>