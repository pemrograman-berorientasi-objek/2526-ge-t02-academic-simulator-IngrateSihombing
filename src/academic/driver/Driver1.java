package academic.driver;

import academic.model.Course;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Menggunakan ArrayList untuk menyimpan Course, karena ini adalah implementasi array
        // yang fleksibel untuk jumlah data yang dinamis.
        ArrayList<Course> courses = new ArrayList<>(); 

        System.out.println("Masukkan data course (kode#nama#sks#grade), ketik '---' untuk berhenti:");

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("---")) {
                break; // Hentikan input jika ditemukan '---'
            }

            // Memecah baris masukan berdasarkan '#'
            String[] parts = line.split("#");

            // Memastikan format input benar (4 segmen)
            if (parts.length == 4) {
                try {
                    String code = parts[0];
                    String name = parts[1];
                    int credits = Integer.parseInt(parts[2]); // Konversi SKS ke integer
                    String grade = parts[3];

                    // Buat objek Course baru dan tambahkan ke ArrayList
                    Course course = new Course(code, name, credits, grade);
                    courses.add(course);
                } catch (NumberFormatException e) {
                    System.err.println("Kesalahan format SKS. Mohon masukkan angka: " + line);
                }
            } else {
                System.err.println("Format input tidak sesuai. Harap gunakan: kode#nama#sks#grade -> " + line);
            }
        }

        scanner.close(); // Tutup scanner setelah selesai membaca input

        System.out.println("\n--- Daftar Course yang Tersimpan ---");
        // Menampilkan semua course yang tersimpan dengan format yang diminta
        for (Course course : courses) {
            System.out.println(course.toString());
        }
    }
}
