/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.dao.DokterDao;
import com.tabeldata.dao.RuangDao;
import com.tabeldata.model.Dokter;
import com.tabeldata.model.Ruang;
import java.io.IOException;
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
@WebServlet(urlPatterns="/ruang/edit")
public class RuangEditController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //    super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        // Integer kodeBuku = Integer.valueOf(req.getParameter("kodeBuku"));
        try {
            Integer kodeRuang = Integer.valueOf(req.getParameter("kodeRuang"));
            Ruang satuRuang = new RuangDao().findById(kodeRuang);
            
            req.setAttribute("ruang", satuRuang);
            req.getRequestDispatcher("/pages/ruang/editRuang.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(RuangEditController.class.getName()).log(Level.SEVERE, null, ex);
        }  
  
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
   Ruang ruang = new Ruang();
       ruang.setId(Integer.valueOf(req.getParameter("idRuang")));
       ruang.setNoRuangan(Integer.valueOf(req.getParameter("noRuangan")));
       ruang.setKosong(Boolean.valueOf(req.getParameter("kosong")));
       
       RuangDao ruangDao = new RuangDao();
        try {
            ruangDao.update(ruang);
        } catch (SQLException ex) {
            Logger.getLogger(RuangAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //cara redirect ada 2:
        //resp.sendRedirect(req.getServletContext().getContextPath()+"/buku/");
        resp.sendRedirect(new StringBuilder(req.getServletContext().getContextPath()).append("/ruang/").toString());
    }
}
