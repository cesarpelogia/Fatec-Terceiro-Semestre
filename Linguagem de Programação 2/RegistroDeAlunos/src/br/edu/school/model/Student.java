package br.edu.school.model;

public class Student {
    
    private String name;
    private int studentId;
    private String course;
    private double exam1;
    private double exam2;
    private double exam3;
    private double exam4;

    public Student() {
        return;
    }

    public Student(String name, int studentId, String course, double exam1, double exam2, double exam3, double exam4) {
        this.name = name;
        this.studentId = studentId;
        this.course = course;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.exam3 = exam3;
        this.exam4 = exam4;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCourse() {
        return course;
    }

    public double getExam1() {
        return exam1;
    }

    public double getExam2() {
        return exam2;
    }

    public double getExam3() {
        return exam3;
    }

    public double getExam4() {
        return exam4;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setExam1(double exam1) {
        this.exam1 = exam1;
    }

    public void setExam2(double exam2) {
        this.exam2 = exam2;
    }

    public void setExam3(double exam3) {
        this.exam3 = exam3;
    }

    public void setExam4(double exam4) {
        this.exam4 = exam4;
    }
}