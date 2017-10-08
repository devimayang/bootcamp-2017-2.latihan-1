/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.dao;

/**
 *
 * @author Devi
 */
import com.tabeldata.configs.KoneksiDatabase;
import com.tabeldata.model.Dokter;
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
public class DokterDao {
    public void save(Dokter x) throws SQLException{
        KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource dataSource = koneksiDB.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "insert into latihan_1.dokter(nama, spesialis) values(?,?)";
        PreparedStatement statement= connection.prepareStatement(sql);
       
        statement.setString(1, x.getNama());
        statement.setString(2, x.getSpesialis());
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void delete(Integer idDokter) throws SQLException{
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = new KoneksiDatabase().getDataSource();
        Connection connection = dataSource.getConnection();
    
        String sql ="delete from latihan_1.dokter where id =?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, idDokter);
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
    
    public List<Dokter> findAll() throws SQLException{
        List<Dokter> listDokter = new ArrayList<>();
        
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = new KoneksiDatabase().getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql ="select id, nama, spesialis from latihan_1.dokter order by nama";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            Dokter dokter = new Dokter();
            dokter.setId(resultSet.getInt("id"));
            dokter.setNama(resultSet.getString("nama"));
            dokter.setSpesialis(resultSet.getString("spesialis"));
            
            listDokter.add(dokter);
        }
        resultSet.close();
        statement.close();
        connection.close();
        
        return listDokter;
    }
    
    public Dokter findById(Integer idDokter) throws SQLException{
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = new KoneksiDatabase().getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql ="select id, nama, spesialis from latihan_1.dokter where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idDokter);
        ResultSet resultSet = statement.executeQuery();
        Dokter dokter = new Dokter();
        if(resultSet.next()){
            dokter.setId(resultSet.getInt("id"));
            dokter.setNama(resultSet.getString("nama"));
            dokter.setSpesialis(resultSet.getString("spesialis"));
        }
        resultSet.close();
        statement.close();
        connection.close();
        
        return dokter;        
    }

    public void update(Dokter dokter) throws SQLException {
         KoneksiDatabase koneksiDB = new KoneksiDatabase();
        DataSource dataSource = koneksiDB.getDataSource();
        Connection connection = dataSource.getConnection();
        
        String sql = "update latihan_1.dokter set nama=?, spesialis=? where id=?";
        
        PreparedStatement statement= connection.prepareStatement(sql);
        statement.setString(1, dokter.getNama());
        statement.setString(2, dokter.getSpesialis());
        statement.setInt(3, dokter.getId());
        
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

}
