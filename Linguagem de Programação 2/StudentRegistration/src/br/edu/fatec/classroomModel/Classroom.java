package br.edu.fatec.classroomModel;

import java.util.ArrayList;
import java.util.List;

import br.edu.fatec.schoolModel.Student;
import br.edu.fatec.textModel.Text;

public class Classroom {

    private String className;
    private List<Student> students;
    private int classroomSize;

    public Classroom(String className, int classroomSize) {
        this.className = className;
        this.students = new ArrayList<>();
        this.classroomSize = classroomSize;
    }

    public boolean addStudent(int studentId, String studentName, String course) {
        if (students.size() >= classroomSize) {
            System.out.println("Sala cheia. Falha ao adicionar o aluno");
            return false;
        }

        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                System.out.println("Id já cadastrado");
                return false;
            }
        }

        Student newStudent = new Student(studentId, studentName, course);
        students.add(newStudent);
        System.out.println("Adicionado aluno: " + newStudent.toString());
        return true;
    }

    public boolean updateStudent(int studentId, String studentName, String course) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                student.setStudentName(studentName);
                student.setCourse(course);
                System.out.println("Aluno atualizado: " + student.toString());
                return true;
            }
        }
        System.out.println("Aluno não encontrado.");
        return false;
    }

    public Student getStudentByName(String name) {
        for (Student student : students) {
            if (student.getStudentName().equals(name)) {
                System.out.println("Aluno encontrado! Nome: " + student.toString());
                return student;
            }
        }
        System.out.println("Aluno não encontrado.");
        return null;
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                System.out.println("Aluno encontrado! Nome: " + student.toString());
                return student;
            }
        }
        System.out.println("Aluno não encontrado.");
        return null;
    }

    public boolean deleteStudentByName(String studentName) {
        for (Student student : students) {
            if (student.getStudentName().equals(studentName)) {
                students.remove(student);
                System.out.println("Estudante removido.");
                return true;
            }
        }
        System.out.println("Estudante não encontrado.");
        return false;
    }

    public boolean addTextToStudent(Student student, Text text) {
        student.addText(text);
        return true;
    }

    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Nenhum aluno matriculado.");
        } else {
            System.out.println("Lista de alunos:");
            for (Student student : students) {
                System.out.println(student.toString());
            }
        }
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getClassroomSize() {
        return classroomSize;
    }

    public void setClassroomSize(int classroomSize) {
        this.classroomSize = classroomSize;
    }
}