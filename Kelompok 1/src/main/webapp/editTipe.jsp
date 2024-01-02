<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Tipe</title>
</head>
<body>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>
<%@ page import="java.util.ArrayList" %>

	<%
		String Tipe_ID = request.getParameter("Tipe_ID");
		TipeModel tipeModel = new TipeModel();
		if(request.getParameter("edittipe") != null){
			String Tipe_Mobil = request.getParameter("Tipe_Mobil");
			tipeModel.updateTipe(Tipe_ID,Tipe_Mobil);
			out.print("<script>location.href='./tableTipe.jsp'</script>");
		}
		Tipe tipe = new Tipe();
		tipe = tipeModel.getTipeByID(Tipe_ID);
	%>
	<form>
	Tipe_ID<input type="text" name="Tipe_ID" value="<% out.print(tipe.getTipe_ID());%>"> <br>
	Tipe_Mobil<input type="text" name="Tipe_Mobil" value="<% out.print(tipe.getTipe_Mobil());%>"> <br>
	<input name="edittipe" value ="Ubah" type="submit"> 
	</form>
</body>
</html>