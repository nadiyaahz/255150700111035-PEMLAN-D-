import java.io.File;

public class DaftarFile {
    public static void main(String[] args) {

        File folder = new File(".");

        File[] daftarFile = folder.listFiles();

        if (daftarFile != null) {

            for (File file : daftarFile) {
                System.out.println(file.getName());
            }

        } else {
            System.out.println("Folder tidak ditemukan");
        }
    }
}