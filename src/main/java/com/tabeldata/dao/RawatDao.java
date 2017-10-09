/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.dao;

import com.tabeldata.configs.KoneksiDatabase;
import com.tabeldata.model.Dokter;
import com.tabeldata.model.Pasien;
import com.tabeldata.model.Rawat;
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
public class RawatDao {
    public void daftarRawat(Rawat x) throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = new KoneksiDatabase().getDataSource();
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);

        String sql = "insert into latihan_1.rawat(pasien_id, dokter_id, ruang_id, waktu_register) values (?,?,?,now())";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, x.getPasien().getId());
        preparedStatement.setInt(2, x.getDokter().getId());
        preparedStatement.setInt(3, x.getRuang().getId());

        preparedStatement.executeUpdate();
        preparedStatement.close();

        sql = "update latihan_1.ruang set kosong='false' where id=?";
        preparedStatement = connection.prepareStatement(sql);
       // preparedStatement.setBoolean(1, x.getRuang().getKosong());
        preparedStatement.setInt(1, x.getRuang().getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        

        connection.commit();
        connection.close();
    }

    public List<Rawat> daftarRawat() throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = new KoneksiDatabase().getDataSource();
        Connection connection = dataSource.getConnection();

        String sql = "SELECT \n"
                + "p.id as pasien_id,\n"
                + "p.nama as nama,\n"
                + "p.alamat as alamat,\n"
                + "p.tanggal_lahir as tanggal_lahir,\n"
                + "d.id as dokter_id,\n"
                + "d.nama as nama_dokter,\n"
                + "d.spesialis as spesialis,\n"
                + "b.id as ruang_id,\n"
                + "b.no_ruangan as no_ruangan,\n"
                + "b.kosong as kosong,\n"
                + "r.id as rawat_id,\n"
                + "r.waktu_register as waktu_register,\n"
                + "r.waktu_checkout as waktu_checkout \n"
                + " from latihan_1.pasien p\n"
                + " join latihan_1.rawat r on p.id=r.pasien_id\n"
                + " join latihan_1.dokter d on d.id=r.dokter_id\n"
                + " join latihan_1.ruang b on b.id=r.ruang_id\n";
                

        List<Rawat> listRawat = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Rawat rawat = new Rawat();

            rawat.setPasien(new Pasien(
                    resultSet.getInt("pasien_id"),
                    resultSet.getString("nama"),
                    resultSet.getString("alamat"),
                    resultSet.getDate("tanggal_lahir")
            ));

            rawat.setDokter(new Dokter(
                    resultSet.getInt("dokter_id"),
                    resultSet.getString("nama_dokter"),
                    resultSet.getString("spesialis")
            ));

			String isEmpty = "";
			if (resultSet.getBoolean("kosong")) isEmpty = "kosong";
			else isEmpty = "Terisi";
            rawat.setRuang(new Ruang(
                    resultSet.getInt("ruang_id"),
                    resultSet.getInt("no_ruangan"),
                    resultSet.getBoolean("kosong"),
					isEmpty
            ));
            rawat.setId(resultSet.getInt("rawat_id"));
            rawat.setWaktuRegister(resultSet.getDate("waktu_register"));
            rawat.setWaktuCheckout(resultSet.getDate("waktu_checkout"));

            listRawat.add(rawat);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return listRawat;
    }

        public void checkout(Integer x, Integer idRuang) throws SQLException {
        KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
        DataSource dataSource = new KoneksiDatabase().getDataSource();
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);

        String sql = "update latihan_1.rawat set waktu_checkout=now() where id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, x);

        preparedStatement.executeUpdate();
        preparedStatement.close();

        sql = "update latihan_1.ruang set kosong=? where id=?";
        preparedStatement = connection.prepareStatement(sql);
       // preparedStatement.setBoolean(1, x.getRuang().getKosong());
        preparedStatement.setBoolean(1, true);
        preparedStatement.setInt(2, idRuang);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        

        connection.commit();
        connection.close();
    }
}

