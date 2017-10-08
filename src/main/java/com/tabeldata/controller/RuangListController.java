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
@WebServlet(urlPatterns={"/ruang/list","/ruang/"})
public class RuangListController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
    try {
            List<Ruang> listRuang = new RuangDao().findAll();
            req.setAttribute("listRuang", listRuang);
        } catch (SQLException ex) {
            Logger.getLogger(RuangListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         req.getRequestDispatcher("/pages/ruang/listRuang.jsp").forward(req,resp);
    }
}
