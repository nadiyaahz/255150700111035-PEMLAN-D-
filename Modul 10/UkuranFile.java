import java.io.File;

public class UkuranFile {
    public static void main(String[] args) {

        File file = new File("test.txt");

        if (file.exists()) {

            long size = file.length();

            System.out.println("Ukuran asli: " + size + " byte");

            if (size < 1024 * 1024) {

                double kb = size / 1024.0;
                System.out.printf("Format output: %.2f KB", kb);

            } else {

                double mb = size / (1024.0 * 1024.0);
                System.out.printf("Format output: %.2f MB", mb);

            }

        } else {
            System.out.println("File tidak ditemukan");
        }
    }
}