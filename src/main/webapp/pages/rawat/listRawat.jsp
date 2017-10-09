<%-- 
    Document   : listRawat
    Created on : Oct 8, 2017, 9:27:03 PM
    Author     : Devi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Pasien Rawat Inap</title>
    </head>
    <body>
         <h1>Tabel Pasien Rawat Inap</h1>
         <a href="${pageContext.servletContext.contextPath}/rawat/daftar">Daftar Rawat Inap</a>  
        <table>
            <thead>
                <tr>
                    <td>No</td>
                    <td>Nama Pasien</td>
                    <td>Nama Dokter</td>
                    <td>No Ruangan</td>
                    <td>Tanggal Masuk</td>
                    <td>Tanggal Keluar</td>
                    <td>Aksi</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listRawat}" var="r" varStatus="idx">
                    <tr>
                        <td>${idx.count}</td>
                        <td>${r.pasien.nama}</td>
                        <td>${r.dokter.nama}</td>
                        <td>${r.ruang.noRuangan}</td>
                        <td>${r.waktuRegister}</td>
                        <td>${r.waktuCheckout}</td>
                        <td>
                            <c:if test ="${r.waktuCheckout!=null}">
                                <c:out value="'Sudah Checkout'"/>
                            </c:if>
                            <c:if test ="${r.waktuCheckout==null}">
                                <a href ="${pageContext.servletContext.contextPath}/rawat/checkout?kode=${r.id}&kode_ruang=${r.ruang.id}">Checkout</a>
                            </c:if>
                        </td>                       
                    </tr>
                </c:forEach>

            </tbody>
        </table>
         
    </body>
</html>

