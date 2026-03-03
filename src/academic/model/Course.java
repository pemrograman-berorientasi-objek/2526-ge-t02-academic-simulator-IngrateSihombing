package academic.model;

public class Course {
    private String code;
    private String name;
    private int credits;
    private String grade; // Diasumsikan segmen keempat adalah nilai/grade

    public Course(String code, String name, int credits, String grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // Metode getter untuk mengakses atribut course
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }

    // Override toString() untuk format output yang diminta
    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}
