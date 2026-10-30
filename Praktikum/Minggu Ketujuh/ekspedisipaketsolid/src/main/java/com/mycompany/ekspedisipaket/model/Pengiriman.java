/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ekspedisipaket.model;

/**
 *
 * @author 7320
 */
public class Pengiriman {
    
    private final String penerima;
    private final String namaLayanan;
    private final double berat;
    private final boolean pakaiAsuransi;
    private final double totalOngkir;
    
    public Pengiriman(
            String penerima, 
            String namaLayanan, 
            double berat, 
            boolean pakaiAsuransi, 
            double totalOngkir
    ) {
        this.penerima = penerima;
        this.namaLayanan = namaLayanan;
        this.berat = berat;
        this.pakaiAsuransi = pakaiAsuransi;
        this.totalOngkir = totalOngkir;
    }
    
    public String getPenerima() {
        return penerima;
    }
    
    public String getNamaLayanan() {
        return namaLayanan;
    }
    
    public double getBerat() {
        return berat;
    }
    
    public boolean isPakaiAsuransi() {
        return pakaiAsuransi;
    }
    
    public double getTotalOngkir() {
        return totalOngkir;
    }
    
    
    
    
    
    
    
    
}
