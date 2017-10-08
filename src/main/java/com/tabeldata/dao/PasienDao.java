/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.dao;

import com.tabeldata.configs.KoneksiDatabase;
import com.tabeldata.model.Pasien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.Instant.now;
import java.util.ArrayList;
import javax.sql.DataSource;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import lombok.experimental.var;
/**
 *
 * @author Devi
 */
public class PasienDao {
    public void save(Pasien x) throws SQLException{
        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource dataSource = koneksiDB.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "insert into latihan_1.pasien( nama, alamat, tanggal_lahir) values(?,?,?)";
        PreparedStatement statement= connection.prepareStatement(sql);
       
        statement.setString(1, x.getNama());
        statement.setString(2, x.getAlamat());
        statement.setDate(3, (java.sql.Date) x.getTanggalLahir());
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void delete(Integer idPasien) throws SQLException{
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = new KoneksiDatabase().getDataSource();
        Connection connection = dataSource.getConnection();
    
        String sql ="delete from latihan_1.pasien where id =?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, idPasien);
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
    
    public List<Pasien> findAll() throws SQLException{
        List<Pasien> listPasien = new ArrayList<>();
        
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = new KoneksiDatabase().getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql ="select id, nama, alamat, tanggal_lahir from latihan_1.pasien order by nama";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            Pasien pasien = new Pasien();
            pasien.setId(resultSet.getInt("id"));
            pasien.setNama(resultSet.getString("nama"));
            pasien.setAlamat(resultSet.getString("alamat"));
            pasien.setTanggalLahir(resultSet.getDate("tanggal_lahir"));
            
            listPasien.add(pasien);
        }
        resultSet.close();
        statement.close();
        connection.close();
        
        return listPasien;
    }
    
    public Pasien findById(Integer idPasien) throws SQLException{
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = new KoneksiDatabase().getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql ="select id, nama, alamat, tanggal_lahir from latihan_1.pasien where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idPasien);
        ResultSet resultSet = statement.executeQuery();
        Pasien pasien = new Pasien();
        if(resultSet.next()){
            pasien.setId(resultSet.getInt("id"));
            pasien.setNama(resultSet.getString("nama"));
            pasien.setAlamat(resultSet.getString("alamat"));
            pasien.setTanggalLahir(resultSet.getDate("tanggal_lahir"));
        }
        resultSet.close();
        statement.close();
        connection.close();
        
        return pasien;        
    }

    public void update(Pasien pasien) throws SQLException {
         KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource dataSource = koneksiDB.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "update latihan_1.pasien set nama=?, alamat=?,tanggal_lahir=? where id=?";
        
        PreparedStatement statement= connection.prepareStatement(sql);
        statement.setString(1, pasien.getNama());
        statement.setString(2, pasien.getAlamat());
        statement.setDate(3, (java.sql.Date) pasien.getTanggalLahir());
        statement.setInt(4, pasien.getId());
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}
