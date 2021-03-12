package io.github.brandpark.promotion;

import java.io.*;
import java.util.Scanner;

import static java.lang.System.exit;

public class Promotion {
    private static String source;
    private static String dest;

    public static void main(String[] args) throws IOException {
        Promotion fc = null;
        //System.getenv("programFiles")
        new Promotion().createFile("test.txt", "C:\\Program Files\\Test");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        if (line == "exit") {
            exit(0);
        }
    }

    public void createFile(String fileName, String destPath) {
        String dest = destPath + "\\" + fileName;

        try (InputStream is = this.getClass().getResourceAsStream(fileName);
             BufferedInputStream bi = new BufferedInputStream(is);
             BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(dest))) {
            int i = -1;
            System.out.println("시작");
            while ((i = bi.read()) != -1) {
                bo.write(i);
            }
            bo.flush();
            System.out.println("끝");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


