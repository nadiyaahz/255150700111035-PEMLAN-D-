import java.util.ArrayList;
import java.util.Collections;

public class Futsal {

    public static void main(String[] args) {
        ArrayList<Integer> tinggiA = new ArrayList<>();
        ArrayList<Integer> beratA = new ArrayList<>();

        ArrayList<Integer> tinggiB = new ArrayList<>();
        ArrayList<Integer> beratB = new ArrayList<>();

        // tim A
        Collections.addAll(tinggiA, 168, 170, 165, 168, 172,
                170, 169, 165, 171, 166);

        Collections.addAll(beratA, 50, 60, 56, 55, 60,
                70, 66, 56, 72, 56);

        // tim B
        Collections.addAll(tinggiB, 170, 167, 165, 166, 168,
                175, 172, 171, 168, 169);

        Collections.addAll(beratB, 66, 60, 59, 58, 58,
                71, 68, 68, 65, 60);

        // sorting data
        System.out.println("------------------- sorting data -------------------");

        // tinggi tim A ascending
        Collections.sort(tinggiA);
        System.out.println("\nTinggi Tim A Ascending : " + tinggiA);

        // tinggi tim A descending
        Collections.sort(tinggiA, Collections.reverseOrder());
        System.out.println("Tinggi Tim A Descending : " + tinggiA);

        // berat tim A ascending
        Collections.sort(beratA);
        System.out.println("\nBerat Tim A Ascending : " + beratA);

        // berat tim A descending
        Collections.sort(beratA, Collections.reverseOrder());
        System.out.println("Berat Tim A Descending : " + beratA);

        // tinggi tim B ascending
        Collections.sort(tinggiB);
        System.out.println("\nTinggi Tim B Ascending : " + tinggiB);

        // tinggi tim B descending
        Collections.sort(tinggiB, Collections.reverseOrder());
        System.out.println("Tinggi Tim B Descending : " + tinggiB);

        // berat tim B ascending
        Collections.sort(beratB);
        System.out.println("\nBerat Tim B Ascending : " + beratB);

        // berat tim B descending
        Collections.sort(beratB, Collections.reverseOrder());
        System.out.println("Berat Tim B Descending : " + beratB);

        // max dan min
        System.out.println("\n-------------------- max dan min --------------------");

        System.out.println("Tim A");
        System.out.println("Tinggi Maksimum : " + Collections.max(tinggiA));
        System.out.println("Tinggi Minimum  : " + Collections.min(tinggiA));
        System.out.println("Berat Maksimum  : " + Collections.max(beratA));
        System.out.println("Berat Minimum   : " + Collections.min(beratA));

        System.out.println("Tim B");
        System.out.println("Tinggi Maksimum : " + Collections.max(tinggiB));
        System.out.println("Tinggi Minimum  : " + Collections.min(tinggiB));
        System.out.println("Berat Maksimum  : " + Collections.max(beratB));
        System.out.println("Berat Minimum   : " + Collections.min(beratB));

        // copy data tim B ke tim C
        ArrayList<Integer> timC = new ArrayList<>();

        timC.addAll(tinggiB);

        System.out.println("\n----------------- copy tim b ke tim c -----------------");
        System.out.println("Data Tim C : " + timC);

        // binary search
        System.out.println("\n-------------------- binary search --------------------");

        // sorting data sebelum binary
        Collections.sort(tinggiB);
        Collections.sort(beratA);

        //mencari tinggi 168 di tim B
        int index168 = Collections.binarySearch(tinggiB, 168);

        if (index168 >= 0) {
            System.out.println("\nTinggi 168 cm ditemukan di Tim B");
            System.out.println("Jumlah pemain tinggi 168 cm : "
                    + Collections.frequency(tinggiB, 168));
        } else {
            System.out.println("\nTinggi 168 cm tidak ditemukan");
        }

        // mencari tinggi 160 di tim B
        int index160 = Collections.binarySearch(tinggiB, 160);

        if (index160 >= 0) {
            System.out.println("Tinggi 160 cm ditemukan");
        } else {
            System.out.println("Jumlah pemain tinggi 160 cm : 0");
        }

        // mencari berat 56 di tim A
        int index56 = Collections.binarySearch(beratA, 56);

        if (index56 >= 0) {
            System.out.println("\nBerat 56 kg ditemukan di Tim A");
            System.out.println("Jumlah pemain berat 56 kg : "
                    + Collections.frequency(beratA, 56));
        } else {
            System.out.println("Berat 56 kg tidak ditemukan");
        }

        // mencari berat 53 di tim A
        int index53 = Collections.binarySearch(beratA, 53);

        if (index53 >= 0) {
            System.out.println("Berat 53 kg ditemukan");
        } else {
            System.out.println("Jumlah pemain berat 53 kg : 0");
        }

        // cek kesamaan data antar tim
        System.out.println("\n--------------- kesamaan data antar tim ---------------");

        boolean tinggiSama = false;
        boolean beratSama = false;

        // cek tinggi badan sama
        for (int tinggi : tinggiA) {
            if (tinggiB.contains(tinggi)) {
                tinggiSama = true;
                break;
            }
        }

        // cek berat badan sama
        for (int berat : beratA) {
            if (beratB.contains(berat)) {
                beratSama = true;
                break;
            }
        }

        if (tinggiSama) {
            System.out.println("Ada tinggi badan yang sama antara Tim A dan Tim B");
        } else {
            System.out.println("Tidak ada tinggi badan yang sama");
        }

        if (beratSama) {
            System.out.println("Ada berat badan yang sama antara Tim A dan Tim B");
        } else {
            System.out.println("Tidak ada berat badan yang sama");
        }
    }
}