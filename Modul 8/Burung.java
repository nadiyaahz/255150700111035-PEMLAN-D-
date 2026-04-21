public class Burung implements MakhlukHidup, Identitas {
    private String nama;
    private int umur;
    private String warnaBulu;

    public Burung(String nama, int umur, String warnaBulu) {
        this.nama = nama;
        this.umur = umur;
        this.warnaBulu = warnaBulu;
    }

    @Override
    public void makan() {
        System.out.println("Makan menggunakan paruh");
    }

    @Override
    public void berjalan() {
        System.out.println("Terbang menggunakan sayap");
    }

    @Override
    public void bersuara() {
        System.out.println("Berkicau mania dengan merdu");
    }

    @Override
    public void tampilkanNama() {
        System.out.println("Nama burung: " + this.nama);
    }

    @Override
    public void tampilkanUmur() {
        System.out.println("Umur burung: " + this.umur + " tahun");
    }
}