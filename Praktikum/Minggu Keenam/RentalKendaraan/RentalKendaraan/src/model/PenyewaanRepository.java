package model;

import java.util.ArrayList;
import java.util.List;

public class PenyewaanRepository {
    private final List<Penyewaan> data = new ArrayList<>();

    public String buatIdBaru() {
        return String.format("SW-%03d", data.size() + 1);
    }

    public void tambah(Penyewaan penyewaan) {
        if (penyewaan == null) {
            throw new IllegalArgumentException("Penyewaan tidak boleh null.");
        }
        for (Penyewaan dataPenyewaan : data) {
            if (dataPenyewaan.getId().equalsIgnoreCase(penyewaan.getId())) {
                throw new IllegalArgumentException("ID penyewaan sudah terdaftar.");
            }
        }
        data.add(penyewaan);
    }

    public List<Penyewaan> semua() {
        return new ArrayList<>(data);
    }

    public Penyewaan cariAktifByPlat(String platNomor) {
        if (platNomor == null || platNomor.isBlank()) {
            return null;
        }
        for (Penyewaan p : data) {
            if (p.isAktif() && p.getKendaraan().getPlatNomor().equalsIgnoreCase(platNomor)) {
                return p;
            }
        }
        return null;
    }
}
