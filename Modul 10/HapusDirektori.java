import java.io.File;

public class HapusDirektori {
    public static void main(String[] args) {

        File folder = new File("Test");

        if (folder.exists() && folder.isDirectory()) {

            File[] files = folder.listFiles();

            if (files != null) {

                for (File file : files) {

                    if (file.delete()) {
                        System.out.println("Terhapus: " + file.getName());
                    } else {
                        System.out.println("Gagal menghapus: " + file.getName());
                    }

                }
            }

            if (folder.delete()) {
                System.out.println("\nDirektori '"  + folder.getName()  + "' berhasil dihapus ");
            } else {
                System.out.println("Direktori gagal dihapus");
            }

        } else {
            System.out.println("Direktori tidak ditemukan");
        }
    }
}