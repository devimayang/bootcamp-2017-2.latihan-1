<%-- 
    Document   : editRuang
    Created on : Oct 8, 2017, 8:14:54 PM
    Author     : Devi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Data Ruang</title>
    </head>
    <body>
        <h1>FORM EDIT DATA RUANG</h1>
        <form action="${pageContext.servletContext.contextPath}/ruang/edit" method="post">
            <input type="hidden" name="idRuang" value="${ruang.id}">
            <div>
                <label for="noRuangan">No Ruangan</label>
                <input type="text" name="noRuangan" id="noRuangan" value="${ruang.noRuangan}">
            </div>
            <div>
                <label for="kosong">Keterangan</label>
                <select>
                    <option value="true">Kosong</option>
                    <option value="false">Terisi</option>
                </select>
            </div>   
           <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
