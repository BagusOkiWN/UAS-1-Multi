<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Daftar Mobil</title>
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

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Penjualan Mobil</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <!-- You may want to replace the href attribute with the actual logout URL -->
            <li class="nav-item">
                <a class="nav-link" href="#">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<h1 style="text-align: center">Penjualan Mobil</h1>
<table class="table table-bordered table-hover">
    <thead class="thead-light">
        <tr>
            <th>No</th>
            <th>Kode Registrasi</th>
            <th>Tipe</th>
            <th>Warna</th>
            <th>Tahun</th>
            <th>CC</th>
            <th>HP</th>
            <th>Harga</th>
            <th>Aksi</th>
        </tr>
    </thead>
    <tbody>
        <% 
            if (session.getAttribute("Username") == null){
                out.print("<script>location.href='./login.jsp'</script>");
            }
            CarsModel carsModel = new CarsModel();
            int jml=carsModel.getAlldata().size();
            for(int i=0; i<jml; i++) {
        %>
        <tr>
            <td><% out.print(i+1); %></td>
            <td><% out.print(carsModel.getAlldata().get(i).getRegistrasi()); %></td>
            <td><% out.print(carsModel.getAlldata().get(i).getNama()); %></td>
            <td><% out.print(carsModel.getAlldata().get(i).getWarna()); %></td>
            <td><% out.print(carsModel.getAlldata().get(i).getTahun()); %></td>
            <td><% out.print(carsModel.getAlldata().get(i).getCc()); %></td>
            <td><% out.print(carsModel.getAlldata().get(i).getPower()); %></td>
            <td><% out.print(carsModel.getAlldata().get(i).getHarga()); %></td>
            <td>
                <a class="btn btn-primary" href="./editCars.jsp?nim=<% out.print (carsModel.getAlldata().get(i).getRegistrasi());%>">Edit</a>
                <a class="btn btn-danger" href="./deleteCars.jsp?nim=<% out.print (carsModel.getAlldata().get(i).getRegistrasi());%>">Delete</a>
            </td>
        </tr>
        <%}%>
    </tbody>
</table>

<!-- Add "Add Mobil" button with margin -->
<a class="btn btn-success add-button" href="./addCars.jsp">Add Mobil</a>

<!-- Add Bootstrap JS and Popper.js (optional) for Bootstrap features -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
