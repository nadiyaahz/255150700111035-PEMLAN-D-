public class KuePesanan extends Kue {
    private double berat; 

    public KuePesanan(String nama, double harga, double berat){
        super(nama, harga);
        this.berat = berat;
    }

    public double getBerat(){
        return berat;
    }

    @Override
    public double hitungHarga(){
        return harga * berat;
    }

    @Override
public String toString(){
    return String.format("%-22s %-12s %-12s %-12s %-15s",
            getNama(),
            formatRupiah(harga),
            ((int) berat) + " gr",
            "-",
            formatRupiah(hitungHarga()));
   }
}