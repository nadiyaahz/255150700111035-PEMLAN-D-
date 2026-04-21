public class Manusia1 implements MakhlukHidup, Identitas {
    private String nama;
    private int umur;

    public Manusia1(String nama, int umur) {
    this.nama = nama;
    this.umur = umur;
}

    @Override
    public void makan() {
        System.out.println("Makan pakai sendok garpu");
    }

    @Override
    public void berjalan() {
        System.out.println("Jalan pakai dua kaki");
    }

    @Override
    public void bersuara() {
        System.out.println("Suaranya merdu");
    }

    @Override
    public void tampilkanNama() {
        System.out.println("Nama saya: " + this.nama);
    }

    @Override
    public void tampilkanUmur() {
        System.out.println("Umur saya: " + this.umur + " tahun");
    }
}
