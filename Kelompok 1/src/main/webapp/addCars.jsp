<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Cars</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        /* Add custom styles for better spacing */
        body {
            padding: 20px;
        }

        form {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <!-- Bootstrap Navbar -->
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

    <!-- Main Content -->
    <h1 style="text-align: center">Add New Car</h1>

    <!-- Car Form -->
    <form action="processAddCar.jsp" method="post">
        <div class="form-group">
            <label for="registrasi">Registration Code:</label>
            <input type="text" class="form-control" id="registrasi" name="registrasi" required>
        </div>
        <div class="form-group">
            <label for="nama">Name:</label>
            <input type="text" class="form-control" id="nama" name="nama" required>
        </div>
        <div class="form-group">
            <label for="warna">Color:</label>
            <input type="text" class="form-control" id="warna" name="warna" required>
        </div>
        <div class="form-group">
            <label for="tahun">Year:</label>
            <input type="text" class="form-control" id="tahun" name="tahun" required>
        </div>
        <div class="form-group">
            <label for="cc">CC:</label>
            <input type="text" class="form-control" id="cc" name="cc" required>
        </div>
        <div class="form-group">
            <label for="power">Power:</label>
            <input type="text" class="form-control" id="power" name="power" required>
        </div>
        <div class="form-group">
            <label for="harga">Price:</label>
            <input type="text" class="form-control" id="harga" name="harga" required>
        </div>
        <button type="submit" class="btn btn-primary">Add Car</button>
    </form>

    <!-- Add Bootstrap JS and Popper.js (optional) for Bootstrap features -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
