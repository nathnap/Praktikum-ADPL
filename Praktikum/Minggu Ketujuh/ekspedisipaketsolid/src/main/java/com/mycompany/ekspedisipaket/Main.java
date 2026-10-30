/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ekspedisipaket;

import com.mycompany.ekspedisipaket.layanan.LayananEkonomi;
import com.mycompany.ekspedisipaket.layanan.LayananPengiriman;
import com.mycompany.ekspedisipaket.layanan.LayananReguler;
import com.mycompany.ekspedisipaket.repository.RiwayatArrayList;
import com.mycompany.ekspedisipaket.repository.RiwayatRepository;
import com.mycompany.ekspedisipaket.service.PengirimanService;
import com.mycompany.ekspedisipaket.view.FormPengiriman;
import java.util.List;

/**
 *
 * @author 7320
 */
public class Main {
    public static void main(String[] args) {
        RiwayatRepository repository = new RiwayatArrayList();
        PengirimanService service = new PengirimanService(repository);
        
        List<LayananPengiriman> daftarLayanan = List.of(
          new LayananReguler(),
          new LayananEkonomi()
        );
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            //logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            FormPengiriman form = new FormPengiriman(service, daftarLayanan);
            form.setLocationRelativeTo(null);
            form.setVisible(true);
        });
    }
    
}
