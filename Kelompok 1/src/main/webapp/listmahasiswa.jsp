<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Daftar Mahasiswa</title>
</head>
<body>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>
<%@ page import="java.util.ArrayList" %>

<table>
	<tr>
		<td>No</td>
		<td>NIM</td>
		<td>Nama</td>
		<td>Kelas</td>
		<td>Action</td>
	</tr>
	<% 	
		
		//ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();	
		if (session.getAttribute("Username") == null){
			out.print("<script>location.href='./login'</script>");
		}
		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		// mahasiswaList.addAll(mahasiswaModel.getAlldata());mahasiswaModel.getAlldata().size();
		int jml=mahasiswaModel.getAlldata().size();
		for(int i=0; i<jml; i++) {
	%>
	<tr>
		<td><% out.print(i+1); %></td>
		<td><% out.print(mahasiswaModel.getAlldata().get(i).getNim()); %></td>
		<td><% out.print(mahasiswaModel.getAlldata().get(i).getNama()); %></td>
		<td><% out.print(mahasiswaModel.getAlldata().get(i).getAlamat()); %></td>
		<td><a href="./editMahasiswa.jsp?nim=<% out.print (mahasiswaModel.getAlldata().get(i).getNim());%>">Edit</a></td>
		
	</tr>
	<%}%>
	
	
</table>
</body>
</html>