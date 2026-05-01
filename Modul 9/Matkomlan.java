public class Matkomlan  extends MataKuliah {
    public Matkomlan() {
        super("Matkomlan");
    }

    @Override
    public double hitungNilaiAkhir() {
        return (nilaiUTS * 0.2) + (nilaiUAS * 0.3) + (nilaiTugas * 0.4) + (nilaiKuis * 0.1) ;
    }
    
}
