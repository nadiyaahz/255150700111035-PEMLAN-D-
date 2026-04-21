public class MainKoperasi {
    public static void main(String[] args) {
        Invoice[] belanjaanKaryawan = {
            new Invoice("Beras 5kg", 1, 75000),
            new Invoice("Gula Pasir", 2, 15000),
            new Invoice("Telur 1kg", 2, 30000),
            new Invoice("Minyak Goreng 2L", 1, 35000),
            new Invoice("Tepung Terigu 1kg", 1, 12000)
        };

        Employee2 emp = new Employee2(140209, "Keonho", 7500000, belanjaanKaryawan);

        emp.displayInfo();
    }
}