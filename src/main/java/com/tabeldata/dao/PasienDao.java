/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.dao;

import com.tabeldata.configs.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static java.time.Instant.now;
import javax.sql.DataSource;
import java.util.Date;
import java.util.Calendar;
import lombok.experimental.var;
/**
 *
 * @author Devi
 */
public class PasienDao {
    public void save() throws SQLException{
        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource dataSource = koneksiDB.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "insert into latihan_1.pasien( nama, alamat, tanggal_lahir) values(?,?,?)";
        PreparedStatement statement= connection.prepareStatement(sql);
       
        statement.setString(1, "Devi");
        statement.setString(2,"bandung");
        statement.setDate(3,java.sql.Date.valueOf("1996-12-04"));
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
    
    public void update(){
        
    }
    
    public void delete(){
        
    }
    
    public void findAll(){
        
    }
    
    public void findById(){
        
    }
}
