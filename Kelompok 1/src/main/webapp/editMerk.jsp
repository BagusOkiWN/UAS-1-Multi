<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Merk</title>
</head>
<body>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>
<%@ page import="java.util.ArrayList" %>

	<%
		String Merk_ID = request.getParameter("Merk_ID");
		MerkModel merkModel = new MerkModel();
		if(request.getParameter("editmerk") != null){
			String Merk_Mobil = request.getParameter("Merk_Mobil");
			merkModel.updateMerk(Merk_ID,Merk_Mobil);
			out.print("<script>location.href='./tableMerk.jsp'</script>");
		}
		Merk merk = new Merk();
		merk = merkModel.getMerkByID(Merk_ID);
	%>
	<form>
	Merk_ID<input type="text" name="Merk_ID" value="<% out.print(merk.getMerk_ID());%>"> <br>
	Merk_Mobil<input type="text" name="Merk_Mobil" value="<% out.print(merk.getMerk_Mobil());%>"> <br>
	<input name="editmerk" value ="ubah" type="submit"> 
	</form>
</body>
</html>