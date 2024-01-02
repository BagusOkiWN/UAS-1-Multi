<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Daftar Warna</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        /* Add custom styles for better spacing */
        body {
            padding: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            margin-bottom: 20px;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            text-decoration: underline;
        }

        /* Add margin to the "Add Mobil" button */
        .add-button {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<%@ page import="id.ac.uns.vokasi.d3ti.database.*" %>
<%@ page import="java.util.ArrayList" %>



<h1 style="text-align: center">Warna</h1>
<table class="table table-bordered table-hover">
    <thead class="thead-light">
        <tr>
            <th>No</th>
            <th>Warna Mobil</th>
            <th>Aksi</th>
        </tr>
    </thead>
    <tbody>
        <% 
            if (session.getAttribute("Username") == null){
                out.print("<script>location.href='./login.jsp'</script>");
            }
            WarnaModel warnaModel = new WarnaModel();
            int jml=warnaModel.getAlldata().size();
            for(int i=0; i<jml; i++) {
        %>
        <tr>
            <td><% out.print(i+1); %></td>
            <td><% out.print(warnaModel.getAlldata().get(i).getWarna_Mobil()); %></td>
            <td>
                <a class="btn btn-primary" href="./editWarna.jsp?Warna_ID=<% out.print (warnaModel.getAlldata().get(i).getWarna_ID());%>">Edit</a>
                <a onclick="hapusWarna()" class="btn btn-danger" href="./hapusWarna.jsp?Warna_ID=<% out.print (warnaModel.getAlldata().get(i).getWarna_ID());%>">Delete</a>
            </td>
        </tr>
        <%}%>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<script>
    function hapusWarna(Warna_ID) {
        if (confirm("Anda yakin ingin menghapus Warna ini?")) {
            window.location.href = "./hapusWarna.jsp?Warna_ID=" + Warna_ID;
        }
    }
</script>

<a class="btn btn-success add-button" href="./tambahWarna.jsp">Add Warna</a>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
