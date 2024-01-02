<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Mahasiswa</title>
</head>
<body>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>
<%@ page import="java.util.ArrayList" %>

	<%
		String nim = request.getParameter("nim");
		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		if(request.getParameter("editmhs") != null){
			String nama = request.getParameter("nama");
			String alamat = request.getParameter("alamat");
			mahasiswaModel.ubahNama(nim,nama);
			mahasiswaModel.updateAlamat(nim, alamat);
			out.print("<script>location.href='./listmahasiswa.jsp'</script>");
		}
		Mahasiswa mhs = new Mahasiswa();
		mhs = mahasiswaModel.getMahasiswaByNim(nim);
	%>
	<form>
	nim<input type="text" name="nim" value="<% out.print(mhs.getNim());%>"> <br>
	nama<input type="text" name="nama" value="<% out.print(mhs.getNama());%>"> <br>
	alamat<textarea  name="alamat" > <% out.print(mhs.getAlamat());%></textarea><br>
	<input name="editmhs" value ="ubah" type="submit"> 
	</form>
</body>
</html>