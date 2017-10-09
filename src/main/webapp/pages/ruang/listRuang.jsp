<%-- 
    Document   : listRuang
    Created on : Oct 8, 2017, 8:12:13 PM
    Author     : Devi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Ruang</title>
    </head>
    <body>
        <h1>Tabel Ruang</h1>
         <a href="${pageContext.servletContext.contextPath}/ruang/new">Tambah Ruang Baru</a>
        <table>
            <thead>
                <tr>
                <td>No</td>
                <td>Nomer Ruangan</td>
                <td>Kosong</td>
                <td>Aksi</td>
                </tr>
            </thead>
            <tbody>                 
                <c:forEach items="${listRuang}" var="satuRuang" varStatus="index">
                <tr>
                <td>${index.count}</td>
                <td>${satuRuang.noRuangan}</td>
                <td>${satuRuang.kosong}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/ruang/delete?kodeRuang=${satuRuang.id}">Hapus</a>
                    <a href="${pageContext.servletContext.contextPath}/ruang/edit?kodeRuang=${satuRuang.id}">Edit</a>
                </td>
                </tr>
                </c:forEach>
                
            </tbody>
        </table>
       
    </body>
</html>
