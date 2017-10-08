<%-- 
    Document   : tambahDokter
    Created on : Oct 8, 2017, 7:34:32 PM
    Author     : Devi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Dokter</title>
    </head>
    <body>
        <h1>FORM PENGISIAN DATA DOKTER</h1>
        <form action="${pageContext.servletContext.contextPath}/dokter/new" method="post">
            <div>
                <label for="nama">Nama Dokter</label>
                <input type="text" name="nama" id="nama">
            </div>
            <div>
                <label for="spesialis">Spesialis</label>
                <input type="text" name="spesialis" id="spesialis">
            </div>   
           <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
