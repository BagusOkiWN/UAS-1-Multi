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
		
		if(request.getParameter("tambahmesin") != null){
			String Mesin_ID = request.getParameter("Mesin_ID");
			MesinModel mesinModel = new MesinModel();
			String Mesin = request.getParameter("Mesin");
			mesinModel.tambahMesin(Mesin_ID,Mesin);
			out.print("<script>location.href='./tableMesin.jsp'</script>");
		}
		Mesin mesin = new Mesin();

	%>
	<form>
	Mesin_ID<input type="text" name="Mesin_ID" value=""> <br>
	Mesin<input type="text" name="Mesin" value=""> <br>
	<input name="tambahmesin" value ="Tambah" type="submit"> 
	</form>
</body>
</html>