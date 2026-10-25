package controller;

import model.Kendaraan;
import model.KendaraanRepository;
import model.Penyewaan;
import model.PenyewaanRepository;
import view.RentalView;
import view.StrukView;

public class RentalController {
    private final KendaraanRepository kendaraanRepo = new KendaraanRepository();
    private final PenyewaanRepository penyewaanRepo = new PenyewaanRepository();
    private final RentalView view = new RentalView();
    private final StrukView strukView = new StrukView();

    public void tambahDataAwal(Kendaraan kendaraan) {
        kendaraanRepo.tambah(kendaraan);
    }

    public void jalankan() {
        while (true) {
            String pilihan = view.tampilMenu();
            switch (pilihan) {
                case "1" -> view.tampilDaftarKendaraan(kendaraanRepo.semua());
                case "2" -> tambahKendaraan();
                case "3" -> sewaKendaraan();
                case "4" -> kembalikanKendaraan();
                case "5" -> view.tampilRiwayat(penyewaanRepo.semua());
                case "0" -> {
                    view.tampilPesan("Thank You.");
                    return;
                }
                default -> view.tampilPesan("Menu tidak ada.");
            }
        }
    }

    public void tambahKendaraan() {
        String plat = view.bacaTeks("Plat Nomor");
        if (plat.isEmpty() || kendaraanRepo.cariByPlat(plat) != null) {
            view.tampilPesan("Plat nomor kosong atau sudah terdaftar.");
            return;
        }

        String merk = view.bacaTeks("Merk");
        if (merk.isEmpty()) {
            view.tampilPesan("Merk tidak boleh kosong.");
            return;
        }
        String jenis = view.bacaTeks("Jenis (MOBIL/MOTOR)").trim().toUpperCase();

        if (!jenis.equals("MOTOR") && !jenis.equals("MOBIL")) {
            view.tampilPesan("Jenis tidak dikenali.");
            return;
        }

        long tarif = view.bacaAngka("Tarif Per Hari");

        if (tarif <= 0) {
            view.tampilPesan("Tarif harus lebih dari 0.");
            return;
        }

        kendaraanRepo.tambah(new Kendaraan(plat, merk, jenis, tarif));
        view.tampilPesan("Kendaraan berhasil ditambahkan");
    }

    public void sewaKendaraan() {
        String plat = view.bacaTeks("Plat Nomor");
        Kendaraan kendaraan = kendaraanRepo.cariByPlat(plat);

        if (kendaraan == null || !kendaraan.isTersedia()) {
            view.tampilPesan("Kendaraan tidak ditemukan atau sedang disewa.");
            return;
        }

        String nama = view.bacaTeks("Nama Penyewa");
        if (nama.isEmpty()) {
            view.tampilPesan("Nama penyewa tidak boleh kosong.");
            return;
        }

        long hariInput = view.bacaAngka("Lama Sewa (hari)");
        if (hariInput < 1) {
            view.tampilPesan("Lama sewa minimal 1 Hari.");
            return;
        }
        if (hariInput > Integer.MAX_VALUE) {
            view.tampilPesan("Lama sewa melebihi batas yang didukung.");
            return;
        }

        int hari = (int) hariInput;
        long total;
        try {
            total = kendaraan.hitungBiaya(hari);
        } catch (ArithmeticException e) {
            view.tampilPesan("Total biaya melebihi batas yang didukung.");
            return;
        }
        String id = penyewaanRepo.buatIdBaru();
        Penyewaan sewa = new Penyewaan(id, nama, kendaraan, hari, total);
        penyewaanRepo.tambah(sewa);
        kendaraan.setTersedia(false);
        strukView.cetak(sewa);
    }

    public void kembalikanKendaraan() {
        String plat = view.bacaTeks("Plat Nomor");
        Penyewaan sewa = penyewaanRepo.cariAktifByPlat(plat);

        if (sewa == null) {
            view.tampilPesan("Tidak ada penyewaan");
            return;
        }

        sewa.selesai();
        sewa.getKendaraan().setTersedia(true);
        view.tampilPesan(
            "Kendaraan " + sewa.getKendaraan().getMerk() + " "
            + sewa.getKendaraan().getPlatNomor() + " telah dikembalikan."
        );
    }
}
