/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.configs;

/**
 *
 * @author Devi
 */
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Devi
 */
public class KoneksiDatabase {
    
    private final static String url="jdbc:postgresql://localhost:5432/bootcamp_latihan", 
            username="bootcamp_latihan", password="latihan";
    
    public DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setUrl(url);
        return ds;
        
    } 
    
   // public static void main(String[] args) throws SQLException { 

        //KoneksiDatabase konekDB = new KoneksiDatabase(); 
         //konekDB.getDataSource().getConnection();
         
   // }
    
}
