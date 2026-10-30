/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ekspedisipaket.layanan;

/**
 *
 * @author 7320
 */
public class LayananEkonomi implements LayananPengiriman {
    
    private static final double TARIF_PER_KG = 7_000;
    private static final double BERAT_MINIMAL = 3;
    
    public String getNama() {
        return "Ekonomi";
    }
    
    public double hitungOngkir(double berat) {
        double beratDihitung = Math.max(berat, BERAT_MINIMAL);
        return beratDihitung * TARIF_PER_KG;
    }
}
