/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.dao.PasienDao;
import com.tabeldata.model.Pasien;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Devi
 */
@WebServlet(urlPatterns="/pasien/new")
public class PasienAddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
    req.getRequestDispatcher("/pages/pasien/tambahPasien.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    Pasien pasien = new Pasien();
    pasien.setNama(req.getParameter("nama"));
    pasien.setAlamat(req.getParameter("alamat"));
    pasien.setTanggalLahir(Date.valueOf(req.getParameter("tanggalLahir")));
    
    PasienDao pasienDao = new PasienDao();
        try {
            pasienDao.save(pasien);
        } catch (SQLException ex) {
            Logger.getLogger(PasienAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        resp.sendRedirect(req.getServletContext().getContextPath()+"/pasien/");
       System.out.println(pasien.toString());
    }
    
    
    
}
