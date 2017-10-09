/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.dao.DokterDao;
import com.tabeldata.dao.PasienDao;
import com.tabeldata.dao.RawatDao;
import com.tabeldata.dao.RuangDao;
import com.tabeldata.model.Dokter;
import com.tabeldata.model.Pasien;
import com.tabeldata.model.Rawat;
import com.tabeldata.model.Ruang;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(urlPatterns="/rawat/daftar")
public class RawatAddController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //    super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
            List<Pasien> listPasien = new PasienDao().findAll();
            List<Dokter> listDokter = new DokterDao().findAll();
            List<Ruang> listRuang = new RuangDao().findAll();
            
            req.setAttribute("listPasien", listPasien);
            req.setAttribute("listDokter", listDokter);
            req.setAttribute("listRuang", listRuang);
            req.getRequestDispatcher("/pages/rawat/addRawat.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(RawatAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //    super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    
       Rawat rawat = new Rawat();
        try {
             Integer pasienId= Integer.valueOf(req.getParameter("pasienId"));
             rawat.setPasien(new PasienDao().findById(pasienId));          
             
             Integer dokterId= Integer.valueOf(req.getParameter("dokterId"));
             rawat.setDokter(new DokterDao().findById(dokterId));
             
             Integer ruangId= Integer.valueOf(req.getParameter("ruangId"));
             rawat.setRuang(new RuangDao().findById(ruangId));
             
             new RawatDao().daftarRawat(rawat);
             
             resp.sendRedirect(new StringBuilder(req.getServletContext().getContextPath()).append("/rawat/list").toString());
        } catch (SQLException ex) {
            Logger.getLogger(RawatAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
             
    }
}
