/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.model;

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
public class Ruang {
    private Integer id;
    private Integer noRuangan;
    private Boolean kosong;
    private String isEmpty;

    public Ruang(int aInt, int aInt0, boolean aBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
