<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tambah Transmisi</title>
</head>
<body>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>
<%@ page import="java.util.ArrayList" %>

	<%
		
		if(request.getParameter("tambahtransmisi") != null){
			String Transmisi_ID = request.getParameter("Transmisi_ID");
			TransmisiModel transmisiModel = new TransmisiModel();
			String Transmisi_Mobil = request.getParameter("Transmisi_Mobil");
			transmisiModel.tambahTransmisi(Transmisi_ID,Transmisi_Mobil);
			out.print("<script>location.href='./tableTransmisi.jsp'</script>");
		}
		Transmisi transmisi = new Transmisi();

	%>
	<form>
	Transmisi_ID<input type="text" name="Transmisi_ID" value=""> <br>
	Transmisi_Mobil<input type="text" name="Transmisi_Mobil" value=""> <br>
	<input name="tambahtransmisi" value ="Tambah" type="submit"> 
	</form>
</body>
</html>