public class MainKue {
    public static void main(String[] args) {

        Kue[] daftarKue = new Kue[20];

        // kue pesanan
        daftarKue[0] = new KuePesanan("Lapis Legit", 150, 1000);
        daftarKue[1] = new KuePesanan("Brownies Panggang", 85, 800);
        daftarKue[2] = new KuePesanan("Black Forest", 250, 1500);
        daftarKue[3] = new KuePesanan("Cheesecake", 180, 1200);
        daftarKue[4] = new KuePesanan("Bolu Gulung Pandan", 28, 6000);
        daftarKue[5] = new KuePesanan("Banana Bread", 30, 1000);
        daftarKue[6] = new KuePesanan("Lapis Surabaya", 30, 1000);
        daftarKue[7] = new KuePesanan("Red Velvet Cake", 220, 1300);
        daftarKue[8] = new KuePesanan("Bika Ambon", 75, 700);
        daftarKue[9] = new KuePesanan("Tiramisu", 190, 1100);

        // kue jadi
        daftarKue[10] = new KueJadi("Nastar", 3000, 50);
        daftarKue[11] = new KueJadi("Kastengel", 2500, 40);
        daftarKue[12] = new KueJadi("Putri Salju", 2000, 45);
        daftarKue[13] = new KueJadi("Donat Gula", 5000, 20);
        daftarKue[14] = new KueJadi("Croissant", 15000, 12);
        daftarKue[15] = new KueJadi("Roti Sobek", 2500, 8);
        daftarKue[16] = new KueJadi("Kue Sagu Keju", 1500, 60);
        daftarKue[17] = new KueJadi("Muffin Cokelat", 12000, 15);
        daftarKue[18] = new KueJadi("Lidah Kucing", 2500, 70);
        daftarKue[19] = new KueJadi("Cinnamon Roll", 18000, 10);

        double totalHarga = 0;
        double totalHargaPesanan = 0;
        double totalBerat = 0;
        double totalHargaJadi = 0;
        double totalJumlah = 0;

        Kue kueTermahal = daftarKue[0];
        System.out.println("=================================================================================");
        System.out.printf("%-22s %-12s %-12s %-12s %-15s\n","Nama", "Harga", "Berat", "Jumlah", "Harga Akhir");
        System.out.println("=================================================================================");
        for (Kue k : daftarKue) {
            System.out.println(k);

            double hargaAkhir = k.hitungHarga();
            totalHarga += hargaAkhir;

            if (k instanceof KuePesanan) {
                KuePesanan kp = (KuePesanan) k;
                totalHargaPesanan += hargaAkhir;
                totalBerat += kp.getBerat();
            } else {
                KueJadi kj = (KueJadi) k;
                totalHargaJadi += hargaAkhir;
                totalJumlah += kj.getJumlah();
            }

            if (hargaAkhir > kueTermahal.hitungHarga()) {
                kueTermahal = k;
            }
        }

        System.out.println("\n===============================================================================");
        System.out.println("Total Harga Semua Kue: " + formatRupiah(totalHarga));
        System.out.println("Total Harga Kue Pesanan: " + formatRupiah(totalHargaPesanan));
        System.out.println("Total Berat Kue Pesanan: " + totalBerat + " gr");
        System.out.println("Total Harga Kue Jadi: " + formatRupiah(totalHargaJadi));
        System.out.println("Total Jumlah Kue Jadi: " + totalJumlah);

        System.out.println("\nKue Termahal:");
        System.out.println(kueTermahal);
        System.out.println("Harga Akhir: " + formatRupiah(kueTermahal.hitungHarga()));
        System.out.println("\n================================================================================");
    }

    public static String formatRupiah(double angka){
        return "Rp" + String.format("%,d", (long) angka).replace(',', '.');
    }
}