<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Warna</title>
</head>
<body>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>
<%@ page import="java.util.ArrayList" %>

	<%
		String Warna_ID = request.getParameter("Warna_ID");
		WarnaModel warnaModel = new WarnaModel();
		if(request.getParameter("editwarna") != null){
			String Warna_Mobil = request.getParameter("Warna_Mobil");
			warnaModel.updateWarna(Warna_ID,Warna_Mobil);
			out.print("<script>location.href='./tableWarna.jsp'</script>");
		}
		Warna warna = new Warna();
		warna = warnaModel.getWarnaByID(Warna_ID);
	%>
	<form>
	Warna_ID<input type="text" name="Warna_ID" value="<% out.print(warna.getWarna_ID());%>"> <br>
	Warna_Mobil<input type="text" name="Warna_Mobil" value="<% out.print(warna.getWarna_Mobil());%>"> <br>
	<input name="editwarna" value ="Ubah" type="submit"> 
	</form>
</body>
</html>