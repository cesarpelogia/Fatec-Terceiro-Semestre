package br.edu.school.model;

public class Classroom {

    private Student[] students;
    private int capacityOfStudents;

    public Classroom(int capacity) {
        students = new Student[capacity];
        capacityOfStudents = 0;
    }

    public Student getStudentById(int studentId) {
        for (Student student : students) {
            if (student != null && student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentByName(String name){
        for (Student student : students) {
            if (student != null && student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }

    public boolean studentExists(int studentId) {
        return getStudentById(studentId) != null;
    }

    public boolean addStudent(Student student) {
        if (capacityOfStudents < students.length && !studentExists(student.getStudentId())) {
            students[capacityOfStudents++] = student;
            return true;
        }
        return false;
    }

    public boolean updateStudent(Student student, Student updateStudent) {
        for (int i = 0; i < capacityOfStudents; i++) {
            if (students[i].getStudentId() == student.getStudentId()) {
                students[i] = updateStudent;
                return true;
            }
        }
        return false;
    }

    public boolean removeStudentById(int studentId){
        for (int i = 0; i < capacityOfStudents; i++) {
            if (students[i].getStudentId() == studentId) {
                for (int j = i; j < capacityOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--capacityOfStudents] = null;
                return true;
            }
        }
    return false;
    }
    
}
