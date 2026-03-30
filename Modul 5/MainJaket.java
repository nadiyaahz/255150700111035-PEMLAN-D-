import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

class Jaket {
    final int hargaA = 100000;
    final int hargaB = 125000;
    final int hargaC = 175000;

    NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

    void tampilHarga() {
        System.out.println("========== Harga Satuan Jaket ===========");
        System.out.println("Jaket A : " + rupiah.format(hargaA));
        System.out.println("Jaket B : " + rupiah.format(hargaB));
        System.out.println("Jaket C : " + rupiah.format(hargaC));
    }

    int hitungHargaA(int jumlah) {
        if (jumlah > 100) {
            System.out.println("Diskon Jaket A berlaku. Harga jadi " + rupiah.format(95000));
            return jumlah * 95000;
        } else {
            return jumlah * hargaA;
        }
    }

    int hitungHargaB(int jumlah) {
        if (jumlah > 100) {
            System.out.println("Diskon Jaket B berlaku. Harga jadi " + rupiah.format(120000));
            return jumlah * 120000;
        } else {
            return jumlah * hargaB;
        }
    }

    int hitungHargaC(int jumlah) {
        if (jumlah > 100) {
            System.out.println("Diskon Jaket C berlaku. Harga jadi " + rupiah.format(160000));
            return jumlah * 160000;
        } else {
            return jumlah * hargaC;
        }
    }
}

public class MainJaket {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Jaket j = new Jaket();

       
        j.tampilHarga();

        System.out.println("\n=========== Input Pembelian ===========");
        System.out.print("Jumlah Jaket A: ");
        int a = input.nextInt();

        System.out.print("Jumlah Jaket B: ");
        int b = input.nextInt();

        System.out.print("Jumlah Jaket C: ");
        int c = input.nextInt();

        System.out.println("\n============= Perhitungan =============");

        int totalA = j.hitungHargaA(a);
        int totalB = j.hitungHargaB(b);
        int totalC = j.hitungHargaC(c);

        int total = totalA + totalB + totalC;

        System.out.println("\n============= Total Harga =============");
        System.out.println("Jaket A: " + j.rupiah.format(totalA));
        System.out.println("Jaket B: " + j.rupiah.format(totalB));
        System.out.println("Jaket C: " + j.rupiah.format(totalC));
        System.out.println("Total Bayar: " + j.rupiah.format(total));
    }
}