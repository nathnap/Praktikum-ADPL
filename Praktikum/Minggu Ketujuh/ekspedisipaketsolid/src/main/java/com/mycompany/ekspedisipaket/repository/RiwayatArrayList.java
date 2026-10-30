/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ekspedisipaket.repository;

import com.mycompany.ekspedisipaket.model.Pengiriman;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 7320
 */
public class RiwayatArrayList implements RiwayatRepository {
    
    private final List<Pengiriman> daftar = new ArrayList<>(); 
    
    public void simpan(Pengiriman pengiriman) {
        daftar.add(pengiriman);
    }
    
    public List<Pengiriman> ambilSemua() {
        return List.copyOf(daftar);
    }
}
