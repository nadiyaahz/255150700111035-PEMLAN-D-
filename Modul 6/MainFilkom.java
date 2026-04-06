public class MainFilkom {
    public static void main(String[] args) {
        Manusia a = new Manusia("A", true, "111", true);
        System.out.println(a);

        mahasiswaFILKOM b = new mahasiswaFILKOM("B", false, "111", false, "165150300111100", 4.0);
        System.out.println("\n" + b);

        Pekerja c = new Pekerja(1000, 2016, 3, 2, 4, "C", "111", true, true);
        System.out.println("\n" + c);

        Manager d = new Manager("HRD", 1000, 2017, 2, 3, 3, "D", "111", true, true);
        System.out.println("\n" + d);
    }
}