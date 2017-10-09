/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.dao;

import com.tabeldata.configs.KoneksiDatabase;
import com.tabeldata.model.Ruang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Devi
 */
public class RuangDao {
     public void save(Ruang x) throws SQLException{
        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource dataSource = koneksiDB.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "insert into latihan_1.ruang(no_ruangan, kosong) values(?,?)";
        PreparedStatement statement= connection.prepareStatement(sql);
       
        statement.setInt(1, x.getNoRuangan());
        statement.setBoolean(2, x.getKosong());
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void delete(Integer idRuang) throws SQLException{
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = new KoneksiDatabase().getDataSource();
        Connection connection = dataSource.getConnection();
    
        String sql ="delete from latihan_1.ruang where id =?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, idRuang);
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
    
    public List<Ruang> findAll() throws SQLException{
        List<Ruang> listRuang = new ArrayList<>();
        
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = new KoneksiDatabase().getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql ="select id, no_ruangan, kosong from latihan_1.ruang order by no_ruangan";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            Ruang ruang = new Ruang();
            ruang.setId(resultSet.getInt("id"));
            ruang.setNoRuangan(resultSet.getInt("no_ruangan"));
            ruang.setKosong(resultSet.getBoolean("kosong"));
			String isEmptyString = "";
			if (resultSet.getBoolean("kosong")) isEmptyString = "Kosong";
			else isEmptyString = "Terisi";
            ruang.setIsEmpty(isEmptyString);
            
            listRuang.add(ruang);
        }
        resultSet.close();
        statement.close();
        connection.close();
        
        return listRuang;
    }
    
    public Ruang findById(Integer idRuang) throws SQLException{
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = new KoneksiDatabase().getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql ="select id, no_ruangan, kosong from latihan_1.ruang where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idRuang);
        ResultSet resultSet = statement.executeQuery();
        Ruang ruang = new Ruang();
        if(resultSet.next()){
            ruang.setId(resultSet.getInt("id"));
            ruang.setNoRuangan(resultSet.getInt("no_ruangan"));
            ruang.setKosong(resultSet.getBoolean("kosong"));
			String isEmptyString = "";
			if (resultSet.getBoolean("kosong")) isEmptyString = "Kosong";
			else isEmptyString = "Terisi";
            ruang.setIsEmpty(isEmptyString);
        }
        resultSet.close();
        statement.close();
        connection.close();
        
        return ruang;        
    }

    public void update(Ruang ruang) throws SQLException {
        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource dataSource = koneksiDB.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "update latihan_1.ruang set no_ruangan=?, kosong=? where id=?";
        
        PreparedStatement statement= connection.prepareStatement(sql);
        statement.setInt(1, ruang.getNoRuangan());
        statement.setBoolean(2, ruang.getKosong());
        statement.setInt(3, ruang.getId());
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}
