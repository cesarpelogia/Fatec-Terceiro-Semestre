package br.edu.school.main;

import br.edu.school.factory.Classroom;
import br.edu.school.factory.Course;
import br.edu.school.factory.Exam;
import br.edu.school.factory.Student;

public class Main {
    public static void main(String[] args) {

        // Iniciando Classroom
        Classroom classroom = new Classroom(Course.LINGUAGEM_DE_PROGRAMAÇÃO_2, 30);
        System.out.println("Iniciada a Turma: " + classroom.getCourse() + ", com capacidade para: " + classroom.capacityOfStudents());

        // Criando e adicionando alunos
        Student student1 = new Student("Carlos Silva", 12345, Course.LINGUAGEM_DE_PROGRAMAÇÃO_2);
        classroom.addStudent(student1);

        Student student2 = new Student("Ana Oliveira", 12346, Course.LINGUAGEM_DE_PROGRAMAÇÃO_2);
        classroom.addStudent(student2);

        // Tentando adicionar um aluno com a mesma matrícula
        Student studentDuplicate = new Student("Carlos Silva", 12345, Course.LINGUAGEM_DE_PROGRAMAÇÃO_2);
        classroom.addStudent(studentDuplicate);

        // Atualizando um aluno
        student1.setName("Carlos Silva Atualizado");
        classroom.updateStudent(student1);
        
        // Adicionando exames para os alunos

        Exam exam1 = new Exam(8, 2);
        classroom.addExam(student1, exam1);
        Exam exam2 = new Exam(7, 3);
        classroom.addExam(student1, exam2);
        Exam exam3 = new Exam(9, 1);
        classroom.addExam(student1, exam3);
        Exam exam4 = new Exam(6, 2);
        classroom.addExam(student1, exam4);

        Exam exam5 = new Exam(7, 9);
        classroom.addExam(student2, exam5);
        Exam exam6 = new Exam(5, 2);
        classroom.addExam(student2, exam6);
        Exam exam7 = new Exam(9, 4);
        classroom.addExam(student2, exam7);
        Exam exam8 = new Exam(7, 7);
        classroom.addExam(student2, exam8);

        // Adicionando um Exam a mais do que deveria

        Exam exam9 = new Exam(8, 4);
        classroom.addExam(student2, exam9);



        Student queriedStudent = classroom.getStudentById(12345);
        if (queriedStudent != null) {
            System.out.println("Aluno encontrado: " + queriedStudent.getName());
            double finalGrade = calculateFinalGrade(queriedStudent);
            System.out.println("Nota final do aluno " + queriedStudent.getName() + ": " + finalGrade );
        } else {
            System.out.println("Aluno não encontrado.");
        }

        queriedStudent = classroom.getStudentByName("Ana Oliveira");
        if (queriedStudent != null) {
            System.out.println("Aluno encontrado: " + queriedStudent.getName());
            double finalGrade = calculateFinalGrade(queriedStudent);
            System.out.println("Nota final do aluno " + queriedStudent.getName() + ": " + finalGrade);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }


    public static double calculateFinalGrade(Student student) {
        Exam[] exams = student.getExams();
        double totalWeightedNotes = 0;
        double totalWeight = 0;

        for (Exam exam : exams) {
            if (exam != null) {
                totalWeightedNotes += exam.getNote() * exam.getWeight();
                totalWeight += exam.getWeight();
                
            }
        }
        if (totalWeight == 0) {
            return 0;
        }
        return totalWeightedNotes / totalWeight;
    }
}



