package view;

import java.util.List;
import java.util.Scanner;
import model.Kendaraan;
import model.Penyewaan;

public class RentalView {
    private final Scanner input = new Scanner(System.in);

    public String tampilMenu() {
        System.out.println();
        System.out.println("======================== RENTAL KENDARAAN ========================");
        System.out.println("1. Lihat Daftar Kendaraan");
        System.out.println("2. Tambah Kendaraan");
        System.out.println("3. Sewa Kendaraan");
        System.out.println("4. Kembalikan Kendaraan");
        System.out.println("5. Riwayat Pesanan");
        System.out.println("0. Keluar");
        return bacaTeks("Pilih Menu");
    }

    public void tampilDaftarKendaraan(List<Kendaraan> daftar) {
        System.out.println("--- Daftar Kendaraan ---");
        if (daftar.isEmpty()) {
            System.out.println("Belum Ada Kendaraan");
            return;
        }

        for (Kendaraan k : daftar) {
            System.out.println(
                k.getPlatNomor() + " | " + k.getMerk() + " | " + k.getJenis()
                + " | " + Format.rupiah(k.getTarifPerHari())
                + " | " + (k.isTersedia() ? "Tersedia" : "Disewakan")
            );
        }
    }

    public void tampilRiwayat(List<Penyewaan> daftar) {
        System.out.println("--- Riwayat Penyewaan ---");
        if (daftar.isEmpty()) {
            System.out.println("Belum Ada Penyewaan");
            return;
        }

        for (Penyewaan p : daftar) {
            System.out.println(
                p.getId() + " | " + p.getNamaPenyewa() + " | " + p.getKendaraan().getMerk()
                + " | " + p.getLamaHari() + " | " + Format.rupiah(p.getTotalBiaya())
                + " | " + (p.isAktif() ? "Berjalan" : "Selesai")
            );
        }
    }

    public String bacaTeks(String label) {
        System.out.print(label + ": ");
        return input.nextLine().trim();
    }

    public long bacaAngka(String label) {
        while (true) {
            String teks = bacaTeks(label);
            try {
                return Long.parseLong(teks);
            } catch (NumberFormatException e) {
                tampilPesan("Input Harus Berupa Angka.");
            }
        }
    }

    public void tampilPesan(String pesan) {
        System.out.println(">> " + pesan);
    }
}
