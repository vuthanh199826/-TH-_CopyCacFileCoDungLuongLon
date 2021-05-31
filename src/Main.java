import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("File nguon :");
        String sourcePath = sc.nextLine();
        System.out.println("File dich");
        String destPath = sc.nextLine();
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        try {
            copyFileUsingJava7Files(sourceFile, destFile);
            System.out.printf("Success");
        } catch (IOException ioe) {
            System.out.printf("error");
            System.out.printf(ioe.getMessage());
        }

    }
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
