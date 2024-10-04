package br.edu.fatec.schoolModel;

import java.util.List;

import br.edu.fatec.textModel.Text;

public class Student {
    private int studentId;
    private String studentName;
    private String course;
    private List<Text> texts;

    public Student(int studentId, String studentName, String course) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<Text> getTexts() {
        return texts;
    }

    public void setTexts(List<Text> texts) {
        this.texts = texts;
    }

    public boolean addText(Text text){
        
        if (texts.size() > 4){
            System.out.println("Todas notas foram preenchidas.");
            return false;
        }
        texts.add(text);
        return true;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}