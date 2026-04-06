public class mahasiswaFILKOM extends Manusia {
    private String nim;
    private double ipk;

    public mahasiswaFILKOM(String nama, boolean jenisKelamin, String nik, boolean menikah, String nim, double ipk){
        super(nama, jenisKelamin, nik, menikah);
        this.nim = nim;
        this.ipk = ipk;
    }

    public double getBeasiswa(){
        if(ipk >= 3.0 && ipk <= 3.5){
            return 50;
        } else if(ipk > 3.5 && ipk <= 4.0){
            return 75;
        }
        return 0;
    }

    public String getStatus(){
        String angkatan = "20" + nim.substring(0, 2);
        char kode = nim.charAt(6);

        String prodi = "";
        switch(kode){
            case '2': prodi = "Teknik Informatika"; break;
            case '3': prodi = "Teknik Komputer"; break;
            case '4': prodi = "Sistem Informasi"; break;
            case '6': prodi = "Pendidikan Teknologi Informasi"; break;
            case '7': prodi = "Teknologi Informasi"; break;
        }

        return prodi + ", " + angkatan;
    }

    @Override
    public double getPendapatan(){
        return super.getPendapatan() + getBeasiswa();
    }

    @Override
    public String toString(){
        return super.toString() + "\n" +
               "NIM            : " + nim + "\n" +
               "IPK            : " + ipk + "\n" +
               "Status         : " + getStatus() + "\n" +
               "Beasiswa       : " + getBeasiswa();
    }
}