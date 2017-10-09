<%-- 
    Document   : addRawat
    Created on : Oct 8, 2017, 9:09:33 PM
    Author     : Devi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>Daftar Rawat Inap</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.contextPath}/rawat/daftar" method="post">
            <div> 
                <label for="ruangId">Pilih Ruang</label>
                <select name="ruangId" id="ruangId">
                    <c:forEach items="${listRuang}" var ="b">
                        <option value="${b.id}">${b.noRuangan}(${b.isEmpty})</option>
                    </c:forEach>
                </select>
            </div>
            <div> 
                <label for="pasienId">Pilih Pasien</label>
                <select name="pasienId" id="pasienId">
                    <c:forEach items="${listPasien}" var="p">
                        <option value="${p.id}">${p.nama}</option>
                    </c:forEach>
                </select>
            </div>
            <div> 
                <label for="dokterId">Pilih Dokter</label>
                <select name="dokterId" id="dokterId">
                    <c:forEach items="${listDokter}" var="d">
                        <option value="${d.id}">${d.nama}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <button type="submit">Daftar Rawat Inap</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
