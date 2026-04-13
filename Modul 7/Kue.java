abstract class Kue {
    private String nama;
    public double harga;

    public Kue(String nama, double harga){
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama(){
        return nama;
    }

    public abstract double hitungHarga();

    protected String formatRupiah(double angka){
        return "Rp" + String.format("%,d", (long) angka).replace(',', '.');
    }

    @Override
    public String toString(){
        return "Nama: " + nama + ", Harga: " + formatRupiah(harga);
    }
}