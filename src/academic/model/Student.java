package academic.model;

public class Student {
    private String id;
    private String name;
    private int year; // Diasumsikan tahun angkatan adalah integer
    private String studyProgram;

    public Student(String id, String name, int year, String studyProgram) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.studyProgram = studyProgram;
    }

    // Metode getter untuk mengakses atribut student
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    // Override toString() untuk format output yang diminta
    @Override
    public String toString() {
        return id + "|" + name + "|" + year + "|" + studyProgram;
    }
}
