package br.edu.school.factory;

public interface StudentOperations {
    
    int numberOfStudents();

    void addStudent(Student student);

    void updateStudent(Student updateStudent);

    Student getStudentById(int studentId);

    Student getStudentByName(String name);

    boolean removeStudentById(int studentId);

    boolean removeStudentByName(String name);

    boolean validateStudent(Student student);

    int capacityOfStudents();

    Course getCourse();

}
