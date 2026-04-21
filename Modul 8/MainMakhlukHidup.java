import java.util.Scanner;

public class MainMakhlukHidup {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan umur: ");
        int umur = input.nextInt();
        Manusia1 m = new Manusia1(nama, umur);

        System.out.print("Masukkan nama hewan: ");
        String namaHewan = input.next();
        System.out.print("Masukkan umur hewan: ");
        int umurHewan = input.nextInt();
        Hewan h = new Hewan(namaHewan, umurHewan);

        System.out.print("Masukkan nama tanaman: ");
        String namaTanaman = input.next();
        System.out.print("Masukkan umur tanaman: ");
        int umurTanaman = input.nextInt();
        Tanaman t = new Tanaman(namaTanaman, umur);



        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("Identitas Manusia");
        m.tampilkanNama();
        m.tampilkanUmur(); 
        m.makan(); 
        m.berjalan();
        m.bersuara();
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("Identitas Hewan");
        h.tampilkanNama();
        h.tampilkanUmur(); 
        h.makan();
        h.berjalan();
        h.bersuara();
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("Identitas Tanaman");
        t.tampilkanNama();
        t.tampilkanUmur();
        t.makan();
        t.berjalan();
        t.bersuara();

        input.close();
    }
}