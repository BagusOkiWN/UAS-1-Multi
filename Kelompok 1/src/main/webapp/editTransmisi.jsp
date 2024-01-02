<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Transmisi</title>
</head>
<body>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>
<%@ page import="java.util.ArrayList" %>

	<%
		String Transmisi_ID = request.getParameter("Transmisi_ID");
		TransmisiModel transmisiModel = new TransmisiModel();
		if(request.getParameter("edittransmisi") != null){
			String Transmisi_Mobil = request.getParameter("Transmisi_Mobil");
			transmisiModel.updateTransmisi(Transmisi_ID,Transmisi_Mobil);
			out.print("<script>location.href='./tableTransmisi.jsp'</script>");
		}
		Transmisi transmisi = new Transmisi();
		transmisi = transmisiModel.getTransmisiByID(Transmisi_ID);
	%>
	<form>
	Tranmisi_ID<input type="text" name="Transmisi_ID" value="<% out.print(transmisi.getTransmisi_ID());%>"> <br>
	Transmisi_Mobil<input type="text" name="Transmisi_Mobil" value="<% out.print(transmisi.getTransmisi_Mobil());%>"> <br>
	<input name="edittransmisi" value ="Ubah" type="submit"> 
	</form>
</body>
</html>