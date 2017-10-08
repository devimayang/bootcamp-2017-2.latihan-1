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
@WebServlet(urlPatterns="/pasien/edit")
public class PasienEditController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //    super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        // Integer kodeBuku = Integer.valueOf(req.getParameter("kodeBuku"));
        try {
            Integer kodePasien = Integer.valueOf(req.getParameter("kodePasien"));
            Pasien satuPasien = new PasienDao().findById(kodePasien);
            
            req.setAttribute("pasien", satuPasien);
            req.getRequestDispatcher("/pages/pasien/editPasien.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(PasienEditController.class.getName()).log(Level.SEVERE, null, ex);
        }  
  
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
   Pasien pasien = new Pasien();
       pasien.setId(Integer.valueOf(req.getParameter("idPasien")));
       pasien.setNama(req.getParameter("nama"));
       pasien.setAlamat(req.getParameter("alamat"));
       pasien.setTanggalLahir(Date.valueOf(req.getParameter("tanggalLahir")));
       
       PasienDao pasienDao = new PasienDao();
        try {
            pasienDao.update(pasien);
        } catch (SQLException ex) {
            Logger.getLogger(PasienAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //cara redirect ada 2:
        //resp.sendRedirect(req.getServletContext().getContextPath()+"/buku/");
        resp.sendRedirect(new StringBuilder(req.getServletContext().getContextPath()).append("/pasien/").toString());
    }
}
