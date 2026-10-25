package App;

import controller.RentalController;
import model.Kendaraan;

public class Main {
    public static void main(String[] args) {
        RentalController controller = new RentalController();

        controller.tambahDataAwal(new Kendaraan(
            "AD 1234 OS",
            "Toyota",
            "MOBIL",
            45000
        ));

        controller.tambahDataAwal(new Kendaraan(
            "B 1234 US",
            "Yamaha",
            "MOTOR",
            20000
        ));

        controller.tambahDataAwal(new Kendaraan(
            "L 1234 KA",
            "Daihatsu",
            "MOBIL",
            55000
        ));

        controller.jalankan();
    }
}
