package br.edu.school.main;

import br.edu.school.factory.Classroom;
import br.edu.school.factory.Course;
import br.edu.school.factory.Student;

public class Main {
    public static void main(String[] args) throws Exception {
        
        // Iniciando Classromm
        Classroom classroom = new Classroom(Course.LINGUAGEM_DE_PROGRAMAÇÃO_2, 30);
        System.out.println("Iniciado Turma: " + classroom.getClassName() + ", com capacidade para: " + classroom.numberOfStudents());

        // Verificando se já existem alunos

        classroom.countNumberOfStudents();

        // Adicionando alunos.
        for (int i =0; i >= 30; i++){
            Student student = new Student("Aluno"+i, i, Course.LINGUAGEM_DE_PROGRAMAÇÃO_2);
            classroom.addStudent(student);
            System.out.println(student);
        }

        // Conferindo o número de alunos após inserção:
        classroom.countNumberOfStudents();

        

    }
}