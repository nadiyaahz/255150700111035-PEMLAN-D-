import java.util.InputMismatchException;
import java.util.Scanner;

public class MainGoDrive {

    static Scanner sc = new Scanner(System.in);
    static GoDriveRentalSystem sistem = new GoDriveRentalSystem();

    public static void main(String[] args) {
        seedData();

        int pilihan = 0;
        do {
            tampilMenu();
            try {
                System.out.print("Pilih menu: ");
                pilihan = sc.nextInt();
                sc.nextLine();

                switch (pilihan) {
                    case 1 -> menuTambahKendaraan();
                    case 2 -> sistem.tampilkanDaftarKendaraan();
                    case 3 -> menuSewa();
                    case 4 -> menuKembalikan();
                    case 5 -> System.out.println("\nTerima kasih telah menggunakan GoDrive Rental System!");
                    default -> System.out.println("[ERROR] Pilihan tidak valid. Masukkan angka 1-5.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] Input harus berupa angka!\n");
                sc.nextLine();
            }
        } while (pilihan != 5);
    }

    static void tampilMenu() {
        System.out.println("========================== MENU GO DRIVE RENTAL SYSTEM ==========================");
        System.out.println("  1. Tambah Kendaraan");
        System.out.println("  2. Tampilkan Daftar Armada");
        System.out.println("  3. Sewa Kendaraan");
        System.out.println("  4. Kembalikan Kendaraan");
        System.out.println("  5. Keluar");
        System.out.println("=================================================================================");
    }

    static void menuTambahKendaraan() {
        System.out.print("Masukkan jenis kendaraan (mobil/motor): ");
        String jenis = sc.nextLine().trim().toLowerCase();

        System.out.print("Masukkan kode kendaraan: ");
        String kode = sc.nextLine().trim().toUpperCase();

        System.out.print("Masukkan nama kendaraan: ");
        String nama = sc.nextLine().trim();

        double harga = 0;
        while (true) {
            try {
                System.out.print("Masukkan harga sewa per hari: ");
                harga = Double.parseDouble(sc.nextLine().trim());
                if (harga <= 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Harga harus berupa angka positif.");
            }
        }

        if (jenis.equals("mobil")) {
            int kursi = 0;
            while (true) {
                try {
                    System.out.print("Masukkan kapasitas kursi: ");
                    kursi = Integer.parseInt(sc.nextLine().trim());
                    if (kursi <= 0) throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] Jumlah kursi harus berupa angka positif.");
                }
            }
            sistem.tambahKendaraan(new Mobil(kode, nama, harga, kursi));
        } else if (jenis.equals("motor")) {
            System.out.print("Masukkan jenis transmisi (Matic/Manual): ");
            String transmisi = sc.nextLine().trim();
            sistem.tambahKendaraan(new Motor(kode, nama, harga, transmisi));
        } else {
            System.out.println("[ERROR] Jenis kendaraan tidak dikenal. Gunakan 'mobil' atau 'motor'.\n");
        }
    }

    static void menuSewa() {
        sistem.tampilkanDaftarKendaraan();
        System.out.print("Masukkan kode kendaraan yang ingin disewa: ");
        String kode = sc.nextLine().trim().toUpperCase();

        int durasi = 0;
        while (true) {
            try {
                System.out.print("Masukkan durasi sewa (dalam hari): ");
                durasi = Integer.parseInt(sc.nextLine().trim());
                if (durasi <= 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Durasi harus berupa angka positif.");
            }
        }

        System.out.print("Apakah Anda Member VIP? (y/n): ");
        String vipInput = sc.nextLine().trim().toLowerCase();
        boolean isVIP = vipInput.equals("y") || vipInput.equals("yes");

        try {
            sistem.sewaKendaraan(kode, durasi, isVIP);
        } catch (KendaraanTidakTersediaException e) {
            System.out.println("Exception in thread \"main\" KendaraanTidakTersediaException: " + e.getMessage());
        }
    }

    static void menuKembalikan() {
        sistem.tampilkanDaftarKendaraan();
        System.out.print("Masukkan kode kendaraan yang ingin dikembalikan: ");
        String kode = sc.nextLine().trim().toUpperCase();
        sistem.kembalikanKendaraan(kode);
        System.out.println();
    }

    static void seedData() {
        //mobil
        sistem.tambahKendaraan(new Mobil("MBL01", "BMW X5 xDrive40i",    950000, 7));
        sistem.tambahKendaraan(new Mobil("MBL02", "Mercedes GLE 450",    1100000, 7));
        sistem.tambahKendaraan(new Mobil("MBL03", "Toyota Fortuner GR",  520000, 7));
        sistem.tambahKendaraan(new Mobil("MBL04", "Audi RS5 Sportback",  450000, 5));
        sistem.tambahKendaraan(new Mobil("MBL05", "Mazda CX-5 Skyactiv", 480000, 5));

        //motor
        sistem.tambahKendaraan(new Motor("MTR01", "Ducati Monster 797",   350000, "Manual"));
        sistem.tambahKendaraan(new Motor("MTR02", "Honda CBR 250RR",      220000, "Manual"));
        sistem.tambahKendaraan(new Motor("MTR03", "Yamaha XMAX 250",      180000, "Matic"));
        sistem.tambahKendaraan(new Motor("MTR04", "Kawasaki Ninja ZX-25R",300000, "Manual"));
        sistem.tambahKendaraan(new Motor("MTR05", "Honda PCX 160",        120000, "Matic"));
        System.out.println();
    }
}
