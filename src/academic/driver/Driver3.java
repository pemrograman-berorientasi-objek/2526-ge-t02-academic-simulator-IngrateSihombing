package academic.driver;

import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        System.out.println("Masukkan data pendaftaran (KodeMatkul#IDMahasiswa#TahunAkademik#Semester), ketik '---' untuk berhenti:");

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("---")) {
                break; // Hentikan input jika ditemukan '---'
            }

            // Memecah baris masukan berdasarkan '#'
            String[] parts = line.split("#");

            // Memastikan format input benar (4 segmen)
            if (parts.length == 4) {
                String courseCode = parts[0];
                String studentId = parts[1];
                String academicYear = parts[2];
                String semester = parts[3];

                // Buat objek Enrollment baru dan tambahkan ke ArrayList
                Enrollment enrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollments.add(enrollment);
            } else {
                System.err.println("Format input tidak sesuai. Harap gunakan: KodeMatkul#IDMahasiswa#TahunAkademik#Semester -> " + line);
            }
        }

        scanner.close(); // Tutup scanner setelah selesai membaca input

        System.out.println("\n--- Daftar Pendaftaran Mahasiswa ---");
        // Menampilkan semua enrollment yang tersimpan dengan format yang diminta
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }
    }
}
