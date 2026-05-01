public class ASD extends MataKuliah {
    public ASD() {
        super("ASD");
    }

    @Override
    public double hitungNilaiAkhir() {
        return (nilaiUTS * 0.2) + (nilaiUAS * 0.4) + (nilaiTugas * 0.2) + (nilaiKuis * 0.2) ;
    }
}
