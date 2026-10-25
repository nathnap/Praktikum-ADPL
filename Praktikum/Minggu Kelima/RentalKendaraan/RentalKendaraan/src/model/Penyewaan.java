package model;

public class Penyewaan {
    private final String id;
    private final String namaPenyewa;
    private final Kendaraan kendaraan;
    private final int lamaHari;
    private final long totalBiaya;
    private boolean aktif = true;

    public Penyewaan(
        String id,
        String namaPenyewa,
        Kendaraan kendaraan,
        int lamaHari,
        long totalBiaya
    ) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID penyewaan tidak boleh kosong.");
        }
        if (namaPenyewa == null || namaPenyewa.isBlank()) {
            throw new IllegalArgumentException("Nama penyewa tidak boleh kosong.");
        }
        if (kendaraan == null) {
            throw new IllegalArgumentException("Kendaraan tidak boleh null.");
        }
        if (lamaHari < 1) {
            throw new IllegalArgumentException("Lama sewa minimal 1 hari.");
        }
        if (totalBiaya <= 0) {
            throw new IllegalArgumentException("Total biaya harus lebih dari 0.");
        }

        this.id = id;
        this.namaPenyewa = namaPenyewa.trim();
        this.kendaraan = kendaraan;
        this.lamaHari = lamaHari;
        this.totalBiaya = totalBiaya;
    }

    public String getId() {
        return id;
    }

    public String getNamaPenyewa() {
        return namaPenyewa;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public int getLamaHari() {
        return lamaHari;
    }

    public long getTotalBiaya() {
        return totalBiaya;
    }

    public boolean isAktif() {
        return aktif;
    }

    public void selesai() {
        this.aktif = false;
    }
}
