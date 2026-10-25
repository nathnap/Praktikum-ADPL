package model;

public class Kendaraan {
    private final String platNomor;
    private final String merk;
    private final String jenis;
    private final long tarifPerHari;
    private boolean tersedia = true;

    public Kendaraan(
        String platNomor,
        String merk,
        String jenis,
        long tarifPerHari
    ) {
        if (platNomor == null || platNomor.isBlank()) {
            throw new IllegalArgumentException("Plat nomor tidak boleh kosong.");
        }
        if (merk == null || merk.isBlank()) {
            throw new IllegalArgumentException("Merk tidak boleh kosong.");
        }
        if (jenis == null) {
            throw new IllegalArgumentException("Jenis kendaraan tidak boleh kosong.");
        }
        String jenisNormal = jenis.trim().toUpperCase();
        if (!jenisNormal.equals("MOBIL") && !jenisNormal.equals("MOTOR")) {
            throw new IllegalArgumentException("Jenis kendaraan harus MOBIL atau MOTOR.");
        }
        if (tarifPerHari <= 0) {
            throw new IllegalArgumentException("Tarif per hari harus lebih dari 0.");
        }

        this.platNomor = platNomor.trim();
        this.merk = merk.trim();
        this.jenis = jenisNormal;
        this.tarifPerHari = tarifPerHari;
    }

    public long hitungBiaya(int hari) {
        if (hari < 1) {
            throw new IllegalArgumentException("Lama sewa minimal 1 hari.");
        }

        long total = Math.multiplyExact(tarifPerHari, hari);

        if (jenis.equals("MOBIL")) {
            total = Math.addExact(total, 50000);
        } else if (hari >= 7) {
            total -= total / 10;
        }
        return total;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public String getMerk() {
        return merk;
    }

    public String getJenis() {
        return jenis;
    }

    public long getTarifPerHari() {
        return tarifPerHari;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
}
