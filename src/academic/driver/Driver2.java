package academic.driver;

import academic.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Masukkan data mahasiswa (ID#Nama#TahunAngkatan#ProgramStudi), ketik '---' untuk berhenti:");

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
                    String id = parts[0];
                    String name = parts[1];
                    int year = Integer.parseInt(parts[2]); // Konversi Tahun Angkatan ke integer
                    String studyProgram = parts[3];

                    // Buat objek Student baru dan tambahkan ke ArrayList
                    Student student = new Student(id, name, year, studyProgram);
                    students.add(student);
                } catch (NumberFormatException e) {
                    System.err.println("Kesalahan format Tahun Angkatan. Mohon masukkan angka: " + line);
                }
            } else {
                System.err.println("Format input tidak sesuai. Harap gunakan: ID#Nama#TahunAngkatan#ProgramStudi -> " + line);
            }
        }

        scanner.close(); // Tutup scanner setelah selesai membaca input

        System.out.println("\n--- Daftar Mahasiswa yang Tersimpan ---");
        // Menampilkan semua student yang tersimpan dengan format yang diminta
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
