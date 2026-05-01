public class Pemlan extends MataKuliah {
    public Pemlan() {
        super("Pemlan");
    }

    //nilai akhir uts 50% dan uas 50%
    @Override
    public double hitungNilaiAkhir() {
        return (nilaiUTS * 0.3) + (nilaiUAS * 0.4) + (nilaiTugas * 0.2) + (nilaiKuis * 0.1) ;
    } 
}
