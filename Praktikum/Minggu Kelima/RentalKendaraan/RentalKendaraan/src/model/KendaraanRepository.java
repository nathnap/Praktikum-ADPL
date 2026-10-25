package model;

import java.util.ArrayList;
import java.util.List;

public class KendaraanRepository {
    private final List<Kendaraan> data = new ArrayList<>();

    public void tambah(Kendaraan kendaraan) {
        if (kendaraan == null) {
            throw new IllegalArgumentException("Kendaraan tidak boleh null.");
        }
        if (cariByPlat(kendaraan.getPlatNomor()) != null) {
            throw new IllegalArgumentException("Plat nomor sudah terdaftar.");
        }
        data.add(kendaraan);
    }

    public List<Kendaraan> semua() {
        return new ArrayList<>(data);
    }

    public Kendaraan cariByPlat(String platNomor) {
        if (platNomor == null || platNomor.isBlank()) {
            return null;
        }
        for (Kendaraan k : data) {
            if (k.getPlatNomor().equalsIgnoreCase(platNomor)) {
                return k;
            }
        }
        return null;
    }
}
