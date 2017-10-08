<%-- 
    Document   : tambahPasien
    Created on : Oct 8, 2017, 2:29:04 PM
    Author     : Devi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Pasien</title>
    </head>
    <body>
        <h1>FORM PENGISIAN DATA PASIEN</h1>
        <form action="${pageContext.servletContext.contextPath}/pasien/new" method="post">
            <div>
                <label for="nama">Nama Pasien</label>
                <input type="text" name="nama" id="nama">
            </div>
            <div>
                <label for="alamat">Alamat Pasien</label>
                <input type="text" name="alamat" id="alamat">
            </div>   
           <div>
                <label for="tanggalLahir">Tanggal Lahir</label>
                <input type="date" name="tanggalLahir" id="tanggalLahir">
            </div> 
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
