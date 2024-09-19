package br.edu.school.factory;

public class Classroom {

    public static final int length = 0;
    private Course course;
    private Student[] students;

    public Classroom(Course course, int capacity) {
        this.course = course;
        this.students = new Student[capacity];
    }

    public void setClassName(Course course){
        this.course = course;
    }
    
    public Course getClassName(){
        return course;
    }


}
