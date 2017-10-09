/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.dao.RawatDao;
import com.tabeldata.dao.RuangDao;
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
@WebServlet(urlPatterns="/rawat/checkout")
public class RawatOutController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //    super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
    
        try {
            Integer kodeRawat = Integer.valueOf(req.getParameter("kode"));
            Integer kodeRuang = Integer.valueOf(req.getParameter("kode_ruang"));
            new RawatDao().checkout(kodeRawat, kodeRuang);
        } catch (SQLException ex) {
            Logger.getLogger(RawatOutController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect(req.getServletContext().getContextPath()+"/rawat/");
    }
}
