/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.katalogbukumvc.controller;

import com.mycompany.katalogbukumvc.model.Buku;
import com.mycompany.katalogbukumvc.model.BukuModel;
import com.mycompany.katalogbukumvc.view.BukuView;

/**
 *
 * @author 7320
 */
public class BukuController {
    private final BukuModel model;
    private final BukuView view;
    
    
    public BukuController(BukuModel model, BukuView view) {
        this.model = model;
        this.view = view;
        
        view.addSimpanListener(event -> simpanBuku());
        view.addHapusListener(event -> hapusBuku());
        view.addClearListener(event -> clearBuku());
        
        view.tampilkanData(model.getSemuaBuku());
    }
    
    public void simpanBuku() {
        String judul = view.getJudul().trim();
        String penulis = view.getPenulis().trim();
        String teksTahun = view.getTahun().trim();
        
        if(judul.isEmpty() || penulis.isEmpty() || teksTahun.isEmpty()) {
            view.tampilkanPeringatan(
                    "Input Belum Lengkap", 
                    "Judul, Penulis, Tahun Terbit Wajib Diisi."
            );
            return;
        }
        
        int tahunTerbit;
        try {
            tahunTerbit = Integer.parseInt(teksTahun);
        } catch (Exception e) {
            view.tampilkanPeringatan(
                    "Input Tidak Valid", 
                    "Tahun Terbit Harus Berupa Angka."
            );
            return;
        }
        
        model.tambahBuku(new Buku(judul, penulis, tahunTerbit));
        view.tampilkanData(model.getSemuaBuku());
        view.kosongkanForm();
    }
    
    
    public void hapusBuku() {
        int baris = view.getBarisTerpilih();
        
        if(baris == -1) {
            view.tampilkanInfo(
                    "hapus Buku", 
                    "Pilih Dulu Baris yang akan dihapus"
            );
            return;
        }
        
        model.hapusBuku(baris);
        view.tampilkanData(model.getSemuaBuku());
    }
    
    public void clearBuku() {
        model.hapusSemua();
        view.tampilkanData(model.getSemuaBuku());
        view.kosongkanForm();
    }
    
}
