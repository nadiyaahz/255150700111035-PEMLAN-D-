import java.util.ArrayList;

public class GoDriveRentalSystem {
    private ArrayList<Kendaraan> daftarKendaraan;

    public GoDriveRentalSystem() {
        daftarKendaraan = new ArrayList<>();
    }

    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
        System.out.println("[INFO] Kendaraan " + k.getNamaKendaraan() + " berhasil ditambahkan ke dalam daftar armada.");
    }

    public void tampilkanDaftarKendaraan() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("[INFO] Belum ada kendaraan terdaftar.");
            return;
        }
        System.out.println("\n=========================== DAFTAR ARMADA GODRIVE ===============================");
        int nomor = 1;
        for (Kendaraan k : daftarKendaraan) {
            System.out.print(nomor++ + ". ");
            k.tampilInfo();
        }
        System.out.println();
    }

    public void sewaKendaraan(String kode, int lamaSewa, boolean isVIP) throws KendaraanTidakTersediaException {
        Kendaraan target = cariKendaraan(kode);

        if (target == null || !target.isTersedia()) {
            throw new KendaraanTidakTersediaException(
                "Kendaraan dengan kode " + kode + " gagal disewa. Alasan: Kendaraan sedang disewa atau tidak ditemukan!"
            );
        }

        double biayaDasar = target.hitungBiayaDasar(lamaSewa);
        double diskonLama = 0;
        double diskonVIP = 0;

        // diskon sewa lebih dari 7 hari 
        if (lamaSewa > 7) {
            diskonLama = biayaDasar * 0.10;
        }

        // diskon member VIP 
        double setelahDiskonLama = biayaDasar - diskonLama;
        if (isVIP) {
            diskonVIP = setelahDiskonLama * 0.10;
        }

        double totalAkhir = setelahDiskonLama - diskonVIP;
        target.setTersedia(false);

        System.out.println("\n============================ TRANSAKSI SEWA GODRIVE ==============================");
        System.out.println("Kendaraan Berhasil Disewa!");
        System.out.printf("%-20s: %s (%s)%n", "Unit", target.getNamaKendaraan(), target.getKodeKendaraan());
        System.out.printf("%-20s: %d hari%n", "Lama Sewa", lamaSewa);
        System.out.printf("%-20s: Rp %,.0f%n", "Biaya Dasar Harian", biayaDasar);

        // Tampilkan biaya tambahan khusus
        if (target instanceof Mobil && ((Mobil) target).getJumlahKursi() > 5) {
            System.out.printf("%-20s: Rp 50,000%n", "Tambahan Kursi (>5)");
        }
        if (target instanceof Motor && ((Motor) target).getJenisTransmisi().equalsIgnoreCase("Matik")) {
            System.out.printf("%-20s: Rp %,.0f%n", "Asuransi Matic", 10000.0 * lamaSewa);
        }
        if (lamaSewa > 7) {
            System.out.printf("%-20s: -Rp %,.0f%n", "Diskon >7 Hari (10%)", diskonLama);
        }
        if (isVIP) {
            System.out.printf("%-20s: -Rp %,.0f%n", "Diskon Member VIP (10%)", diskonVIP);
        }

        System.out.println("\n---------------------------------------------------------------------------------");
        System.out.printf("Total Biaya Akhir   : Rp %,.0f%n%n", totalAkhir);
        System.out.printf("Terima kasih sudah menggunakan layanan Go Drive!");
        System.out.println("\n---------------------------------------------------------------------------------");
    }

    public void kembalikanKendaraan(String kode) {
        Kendaraan target = cariKendaraan(kode);

        if (target == null) {
            System.out.println("[ERROR] Kendaraan dengan kode " + kode + " tidak ditemukan.");
            return;
        }
        if (target.isTersedia()) {
            System.out.println("[WARN] Kendaraan " + target.getNamaKendaraan() + " tidak sedang dalam status sewa.");
            return;
        }

        target.setTersedia(true);
        System.out.println("[INFO] Kendaraan " + target.getNamaKendaraan() + " (" + kode + ") berhasil dikembalikan. Status: Tersedia.");
    }

    private Kendaraan cariKendaraan(String kode) {
        for (Kendaraan k : daftarKendaraan) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        return null;
    }
}
