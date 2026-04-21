public class Tanaman implements MakhlukHidup, Identitas {
    private String nama;
    private int umur;

    public Tanaman(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    @Override
    public void makan() {
        System.out.println("Makan lewat fotosintesis");
    }

    @Override
    public void berjalan() {
        System.out.println("Tidak berjalan, hanya diam di tempat");
    }

    @Override
    public void bersuara() {
        System.out.println("Tidak bersuara");
    }

    @Override
    public void tampilkanNama() {
        System.out.println("Nama tanaman: " + this.nama);
    }

    @Override
    public void tampilkanUmur() {
        System.out.println("Umur tanaman: " + this.umur + " minggu");
    }
}
