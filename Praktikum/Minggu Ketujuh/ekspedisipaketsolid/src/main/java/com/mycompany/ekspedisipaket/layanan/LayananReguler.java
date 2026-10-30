/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ekspedisipaket.layanan;

/**
 *
 * @author 7320
 */
public class LayananReguler implements LayananPengiriman, BisaDiasuransikan {
    
    private static final double TARIF_PER_KG = 10_000;
    private static final double BIAYA_ASURANSI = 3_000;
    
    public String getNama() {
        return "Reguler";
    }
    
    public double hitungOngkir(double berat) {
        return berat * TARIF_PER_KG;
    }
    
    public double getBiayaAsuransi() {
        return BIAYA_ASURANSI;
    }
}
