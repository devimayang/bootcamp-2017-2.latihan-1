<%-- 
    Document   : listDokter
    Created on : Oct 8, 2017, 7:29:04 PM
    Author     : Devi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Dokter</title>
    </head>
    <body>
        <h1>Tabel Dokter</h1>
        <table>
            <thead>
                <tr>
                <td>No</td>
                <td>Nama</td>
                <td>Spesialis</td>
                <td>Aksi</td>
                </tr>
            </thead>
            <tbody>                 
                <c:forEach items="${listDokter}" var="satuDokter" varStatus="index">
                <tr>
                <td>${index.count}</td>
                <td>${satuDokter.nama}</td>
                <td>${satuDokter.spesialis}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/dokter/delete?kodeDokter=${satuDokter.id}">Hapus</a>
                    <a href="${pageContext.servletContext.contextPath}/dokter/edit?kodeDokter=${satuDokter.id}">Edit</a>
                </td>
                </tr>
                </c:forEach>
                
            </tbody>
        </table>
    <a href="${pageContext.servletContext.contextPath}/dokter/new">Tambah</a>    
    </body>
</html>
