package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.ArrayList;
import java.util.List; // Menggunakan List interface untuk fleksibilitas
import java.util.Scanner;

public class Driver4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Menggunakan List untuk menyimpan koleksi dari setiap entitas
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();

        System.out.println("Masukkan data (course-add#... atau student-add#... atau enrollment-add#...), ketik '---' untuk berhenti:");

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("---")) {
                break; // Hentikan input jika ditemukan '---'
            }

            String[] parts = line.split("#");

            if (parts.length > 0) {
                String command = parts[0];

                switch (command) {
                    case "course-add":
                        // Format: course-add#code#name#credits#grade
                        if (parts.length == 5) { // Command + 4 data
                            try {
                                String code = parts[1];
                                String name = parts[2];
                                int credits = Integer.parseInt(parts[3]);
                                String grade = parts[4];
                                Course course = new Course(code, name, credits, grade);
                                courses.add(course);
                            } catch (NumberFormatException e) {
                                System.err.println("Kesalahan format SKS pada input Course: " + line);
                            }
                        } else {
                            System.err.println("Format input Course tidak sesuai: " + line);
                        }
                        break;

                    case "student-add":
                        // Format: student-add#id#name#year#studyProgram
                        if (parts.length == 5) { // Command + 4 data
                            try {
                                String id = parts[1];
                                String name = parts[2];
                                int year = Integer.parseInt(parts[3]);
                                String studyProgram = parts[4];
                                Student student = new Student(id, name, year, studyProgram);
                                students.add(student);
                            } catch (NumberFormatException e) {
                                System.err.println("Kesalahan format Tahun Angkatan pada input Student: " + line);
                            }
                        } else {
                            System.err.println("Format input Student tidak sesuai: " + line);
                        }
                        break;

                    case "enrollment-add":
                        // Format: enrollment-add#courseCode#studentId#academicYear#semester
                        if (parts.length == 5) { // Command + 4 data
                            String courseCode = parts[1];
                            String studentId = parts[2];
                            String academicYear = parts[3];
                            String semester = parts[4];
                            // Grade otomatis "None" dari constructor Enrollment
                            Enrollment enrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                            enrollments.add(enrollment);
                        } else {
                            System.err.println("Format input Enrollment tidak sesuai: " + line);
                        }
                        break;

                    default:
                        System.err.println("Perintah tidak dikenal: " + command + " pada baris: " + line);
                        break;
                }
            } else {
                System.err.println("Input kosong atau tidak valid: " + line);
            }
        }

        scanner.close(); // Tutup scanner setelah selesai membaca input

        // Menampilkan semua Course yang tersimpan
        for (Course course : courses) {
            System.out.println(course.toString());
        }

        // Menampilkan semua Student yang tersimpan
        for (Student student : students) {
            System.out.println(student.toString());
        }

        // Menampilkan semua Enrollment yang tersimpan
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }
    }
}
