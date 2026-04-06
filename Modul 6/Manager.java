public class Manager extends Pekerja {
    private String departemen;

    public Manager(String departemen, double gaji, int tahun, int bulan, int hari, int jumlahAnak,
                   String nama, String nik, boolean jenisKelamin, boolean menikah){

        super(gaji, tahun, bulan, hari, jumlahAnak, nama, nik, jenisKelamin, menikah);
        this.departemen = departemen;
    }

    @Override
    public double getTunjangan(){
        return super.getTunjangan() + (0.10 * super.getGaji());
    }

     @Override
    public String toString(){
        return super.toString() + "\n" +
               "departemen     : " + departemen;
    }
}