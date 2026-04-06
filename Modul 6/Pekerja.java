import java.time.LocalDate;
import java.time.Period;

public class Pekerja extends Manusia {
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;
   
     public Pekerja(double gaji, int tahun, int bulan, int hari, int jumlahAnak,
                   String nama, String nik, boolean jenisKelamin, boolean menikah){

        super(nama, jenisKelamin, nik, menikah);
        this.gaji = gaji;
        this.tahunMasuk = LocalDate.of(tahun, bulan, hari);
        this.jumlahAnak = jumlahAnak;
    }
    public double getBonus(){
        int lamaKerja = Period.between(tahunMasuk, LocalDate.now()).getYears();

        if(lamaKerja >= 0 && lamaKerja <= 5){
            return 0.05 * gaji;
        } else if(lamaKerja >=6 && lamaKerja <= 10){
            return 0.10 * gaji;
        } else {
            return 0.15 * gaji;
        }
    }

    public double getGaji(){
        return gaji + getBonus() + (jumlahAnak * 20);
    }

    @Override
    public double getPendapatan(){
        return super.getPendapatan() + getGaji();
    }
   
   @Override
public String toString(){
    return super.toString() + "\n" +
          "tahun masuk    : " + 
          tahunMasuk.getDayOfMonth() + " " +
          tahunMasuk.getMonthValue() + " " +
          tahunMasuk.getYear() + "\n" +
           "jumlah anak    : " + jumlahAnak + "\n" +
           "gaji           : " + gaji;
   }
}


