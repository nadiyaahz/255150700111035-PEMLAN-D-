public class Manusia {
    private String nama;
    boolean jenisKelamin;
    private String nik;
    private boolean menikah;

    public Manusia(){

    }

     public Manusia(String nama, boolean jenisKelamin, String nik, boolean menikah){
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.nik = nik;
        this.menikah = menikah;
    }

    public double getTunjangan(){
        if (menikah){
            if(jenisKelamin){
                return 25;//laki
            } else {
                return 20;//perempuan
            }
        }
        return 15;//belum menikah
    }

    public double getPendapataN(){
        return getTunjangan();
    }
    public double getPendapatan(){
        return getTunjangan();
    }
    
   @Override
    public String toString(){  
        return "Nama           : " + nama +
           "\nNIK            : " + nik +
           "\nJenis Kelamin  : " + (jenisKelamin ? "Laki-laki" : "Perempuan") +
           "\nPendapatan     : " + getPendapatan();

        
    }
 }

    
    

    

