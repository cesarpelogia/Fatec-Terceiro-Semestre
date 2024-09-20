package br.edu.school.factory;

public class Student  {

    
    private String name;
    private int studentId;
    private Course course;
    private Exam[] exams;
    
    public Student(String name, int studentId, Course course) {
        this.name = name;
        this.studentId = studentId;
        this.course = course;
        this.exams = new Exam[4];
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getStudentId() {
        return studentId;
    }

    public Course getCourse() {
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

    public void setCourse(Course course) {
        this.course = course;
    }

    public boolean addExamStudent(Exam exam) {
        for (int i = 0; i < exams.length; i++) {
            if (exams[i] == null) {
                exams[i] = exam;
                return true;
            }
        }
        return false; // Retorna false se não houver espaço no array
    }
    
}