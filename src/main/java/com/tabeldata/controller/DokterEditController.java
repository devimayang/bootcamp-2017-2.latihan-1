/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.dao.DokterDao;
import com.tabeldata.dao.PasienDao;
import com.tabeldata.model.Dokter;
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
@WebServlet(urlPatterns="/dokter/edit")
public class DokterEditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //    super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        // Integer kodeBuku = Integer.valueOf(req.getParameter("kodeBuku"));
        try {
            Integer kodeDokter = Integer.valueOf(req.getParameter("kodeDokter"));
            Dokter satuDokter = new DokterDao().findById(kodeDokter);
            
            req.setAttribute("dokter", satuDokter);
            req.getRequestDispatcher("/pages/dokter/editDokter.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(DokterEditController.class.getName()).log(Level.SEVERE, null, ex);
        }  
  
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
   Dokter dokter = new Dokter();
       dokter.setId(Integer.valueOf(req.getParameter("idDokter")));
       dokter.setNama(req.getParameter("nama"));
       dokter.setSpesialis(req.getParameter("spesialis"));
       
       DokterDao dokterDao = new DokterDao();
        try {
            dokterDao.update(dokter);
        } catch (SQLException ex) {
            Logger.getLogger(DokterAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //cara redirect ada 2:
        //resp.sendRedirect(req.getServletContext().getContextPath()+"/buku/");
        resp.sendRedirect(new StringBuilder(req.getServletContext().getContextPath()).append("/dokter/").toString());
    }
}
