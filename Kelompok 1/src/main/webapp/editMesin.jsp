<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Tipe Mesin</title>
</head>
<body>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>
<%@ page import="java.util.ArrayList" %>

	<%
		String Mesin_ID = request.getParameter("Mesin_ID");
		MesinModel mesinModel = new MesinModel();
		if(request.getParameter("editmesin") != null){
			String Mesin = request.getParameter("Mesin");
			mesinModel.updateMesin(Mesin_ID,Mesin);
			out.print("<script>location.href='./tableMesin.jsp'</script>");
		}
		Mesin mesin = new Mesin();
		mesin = mesinModel.getMesinByID(Mesin_ID);
	%>
	<form>
	Mesin_ID<input type="text" name="Mesin_ID" value="<% out.print(mesin.getMesin_ID());%>"> <br>
	Mesin<input type="text" name="Mesin" value="<% out.print(mesin.getMesin());%>"> <br>
	<input name="editmesin" value ="ubah" type="submit"> 
	</form>
</body>
</html>