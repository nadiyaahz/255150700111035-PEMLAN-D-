public class KueJadi extends Kue {
    private double jumlah;

    public KueJadi(String nama, double harga, double jumlah){
        super(nama, harga);
        this.jumlah = jumlah;
    }

    public double getJumlah(){
        return jumlah;
    }

    @Override
    public double hitungHarga(){
        return harga * jumlah * 2;
    }

@Override
public String toString(){
    return String.format("%-22s %-12s %-12s %-12s %-15s",
            getNama(),
            formatRupiah(harga),
            "-",
            (int) jumlah,
            formatRupiah(hitungHarga()));
    }
}