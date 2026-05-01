public abstract class MataKuliah {
    protected String nama;
    protected int nilaiUTS;
    protected int nilaiUAS;
    protected int nilaiTugas;
    protected int nilaiKuis;


    public MataKuliah(String namaString) {
        this.nama = namaString;
    }  
    
    public String getNama() {
        return nama;
    }

    public void setNilai(int nilaiUTS, int nilaiUAS, int nilaiTugas, int nilaiKuis) {
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
        this.nilaiTugas = nilaiTugas;
        this.nilaiKuis = nilaiKuis;
    }
    public abstract double hitungNilaiAkhir();

    public String getGrade() {
        double nilaiAkhir = hitungNilaiAkhir();
        if (nilaiAkhir >= 85) {
            return "A";
        } else if (nilaiAkhir >= 70) {
            return "B";
        } else if (nilaiAkhir >= 55) {
            return "C";
        } else if (nilaiAkhir >= 40) {
            return "D";
        } else {
            return "E";
        }
    }
}
