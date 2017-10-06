/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Devi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pasien {
    private Integer id;
    private String nama;
    private String alamat;
    private Date tanggalLahir;
}
