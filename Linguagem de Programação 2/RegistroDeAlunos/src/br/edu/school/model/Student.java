package br.edu.school.model;

public class Student {
    
    private String name;
    private int studentId;
    private String course;
    private Exam[] exams;

    public Student(String name, int studentId, String course) {
        this.name = name;
        this.studentId = studentId;
        this.course = course;
        this.exams = new Exam[4];
    }

    public boolean addExam(Exam exam){
        for (int i = 0; i < exams.length; i++){
            if (exams[i] == null){
                exams[i] = exam;
                return true;
            }
        }
        return false;
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
    
    public Exam[] getExams() {
        return exams;
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
}