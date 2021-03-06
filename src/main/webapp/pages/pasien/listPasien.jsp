<%-- 
    Document   : listPasien
    Created on : Oct 6, 2017, 4:37:25 PM
    Author     : Devi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Pasien</title>
    </head>
    <body>
        <h1>Tabel Pasien</h1>
        <a href="${pageContext.servletContext.contextPath}/pasien/new">Daftar Pasien Baru</a>
        <table>
            <thead>
                <tr>
                <td>No</td>
                <td>Nama</td>
                <td>Alamat</td>
                <td>Tanggal Lahir</td>
                <td>Aksi</td>
                </tr>
            </thead>
            <tbody>                 
                <c:forEach items="${listPasien}" var="satuPasien" varStatus="index">
                <tr>
                <td>${index.count}</td>
                <td>${satuPasien.nama}</td>
                <td>${satuPasien.alamat}</td>
                <td>${satuPasien.tanggalLahir}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/pasien/delete?kodePasien=${satuPasien.id}">Hapus</a>
                    <a href="${pageContext.servletContext.contextPath}/pasien/edit?kodePasien=${satuPasien.id}">Edit</a>
                </td>
                </tr>
                </c:forEach>
                
            </tbody>
        </table>
        
    </body>
</html>
