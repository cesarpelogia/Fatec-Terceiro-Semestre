package br.edu.school.main;

import java.util.Scanner;

import br.edu.school.factory.Classroom;
import br.edu.school.factory.Course;
import br.edu.school.factory.Student;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nOlá, seja bem vindo. \nPrimeiro, precisamos criar uma classe:\n");
        System.out.println("Selecione o curso que você quer criar a classe:\n");
        System.out.println("1. Estrutura de Dados");
        System.out.println("2. Linguagem de Programação 2");
        System.out.println("3. Programação de Banco de Dados");
        System.out.println("4. Laboratório de Banco de Dados");

        int escolha = scanner.nextInt();
        Course cursoSelecionado;

        switch (escolha) {
            case 1:
                cursoSelecionado = Course.ESTRUTURA_DE_DADOS;
                break;
            case 2:
                cursoSelecionado = Course.LINGUAGEM_DE_PROGRAMAÇÃO_2;
                break;
            case 3:
                cursoSelecionado = Course.PROGRAMAÇÃO_DE_BANCO_DE_DADOS;
                break;
            case 4:
                cursoSelecionado = Course.LABORATÓRIO_DE_BANCO_DE_DADOS;
                break;
            default:
                System.out.println("Opção inválida. Selecionando Linguagem de Programação 2 por padrão.");
                cursoSelecionado = Course.LINGUAGEM_DE_PROGRAMAÇÃO_2;
                break;
        }

        System.out.println("Ok. A classe escolhida foi " + cursoSelecionado);
        System.out.println("Agora, escolha a capacidade da classe: ");

        int capacity = scanner.nextInt();

        Classroom lp2 = new Classroom(cursoSelecionado, capacity);

        System.out.println("A classe " + lp2.getClassName() + " com a capacidade de " + capacity + " alunos.\n");

        System.out.println("\nAgora, iremos adicionar os alunos. Você gostaria de inserir os alunos automaticamente?");
        System.out.println("1. Manualmente.");
        System.out.println("2. Automaticamente.\n");
        System.out.println("Insira a opção: ");

        int insercaoAluno = scanner.nextInt();

        switch (insercaoAluno) {
            case 1:
                for (int i = 0; i < capacity; i++) {
                    System.out.println("Insira o nome do Aluno (ou digite 'sair' para parar): ");
                    String nome = scanner.next();

                    if (nome.equalsIgnoreCase("sair")) {
                        System.out.println("Parando a adição de alunos.\n");
                        break;
                    }

                    Student aluno = new Student(nome, i, cursoSelecionado);
                    lp2.addStudent(aluno);
                    System.out.println("Adicionado " + aluno.getName() + " com ID: " + aluno.getStudentId() + " na materia " + aluno.getCourse() + "\n");
                }
                break;
            case 2:
            Student student1 = new Student("Ana", 0, cursoSelecionado);
            lp2.addStudent(student1);
            
            Student student2 = new Student("Bruno", 1, cursoSelecionado);
            lp2.addStudent(student2);
            
            Student student3 = new Student("Carlos", 2, cursoSelecionado);
            lp2.addStudent(student3);
            
            Student student4 = new Student("Daniela", 3, cursoSelecionado);
            lp2.addStudent(student4);
            
            Student student5 = new Student("Eduardo", 4, cursoSelecionado);
            lp2.addStudent(student5);
            
            Student student6 = new Student("Fernanda", 5, cursoSelecionado);
            lp2.addStudent(student6);
            
            Student student7 = new Student("Gabriel", 6, cursoSelecionado);
            lp2.addStudent(student7);
            
            Student student8 = new Student("Helena", 7, cursoSelecionado);
            lp2.addStudent(student8);
            
            Student student9 = new Student("Igor", 8, cursoSelecionado);
            lp2.addStudent(student9);
            
            Student student10 = new Student("Juliana", 9, cursoSelecionado);
            lp2.addStudent(student10);
            
            Student student11 = new Student("Lucas", 10, cursoSelecionado);
            lp2.addStudent(student11);
            
            Student student12 = new Student("Mariana", 11, cursoSelecionado);
            lp2.addStudent(student12);
            
            Student student13 = new Student("Nicolas", 12, cursoSelecionado);
            lp2.addStudent(student13);
            
            Student student14 = new Student("Olivia", 13, cursoSelecionado);
            lp2.addStudent(student14);
            
            Student student15 = new Student("Pedro", 14, cursoSelecionado);
            lp2.addStudent(student15);
            
            Student student16 = new Student("Quintino", 15, cursoSelecionado);
            lp2.addStudent(student16);
            
            Student student17 = new Student("Rafaela", 16, cursoSelecionado);
            lp2.addStudent(student17);
            
            Student student18 = new Student("Sofia", 17, cursoSelecionado);
            lp2.addStudent(student18);
            
            Student student19 = new Student("Tiago", 18, cursoSelecionado);
            lp2.addStudent(student19);
            
            Student student20 = new Student("Ursula", 19, cursoSelecionado);
            lp2.addStudent(student20);
            
            Student student21 = new Student("Victor", 20, cursoSelecionado);
            lp2.addStudent(student21);
            
            Student student22 = new Student("Wagner", 21, cursoSelecionado);
            lp2.addStudent(student22);
            
            Student student23 = new Student("Xavier", 22, cursoSelecionado);
            lp2.addStudent(student23);
            
            Student student24 = new Student("Yasmin", 23, cursoSelecionado);
            lp2.addStudent(student24);
            
            Student student25 = new Student("Zara", 24, cursoSelecionado);
            lp2.addStudent(student25);
            
            Student student26 = new Student("Arthur", 25, cursoSelecionado);
            lp2.addStudent(student26);
            
            Student student27 = new Student("Beatriz", 26, cursoSelecionado);
            lp2.addStudent(student27);
            
            Student student28 = new Student("Caio", 27, cursoSelecionado);
            lp2.addStudent(student28);
            
            Student student29 = new Student("Diana", 28, cursoSelecionado);
            lp2.addStudent(student29);
            
            Student student30 = new Student("Eduarda", 29, cursoSelecionado);
            lp2.addStudent(student30);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }

        while (true) {
            System.out.println("Escolha uma ação:");
            System.out.println("1. Adicionar aluno");
            System.out.println("2. Atualizar aluno");
            System.out.println("3. Buscar aluno por nome");
            System.out.println("4. Buscar aluno por ID");
            System.out.println("5. Remover aluno por nome");
            System.out.println("6. Remover aluno por ID");
            System.out.println("7. Validar aluno");
            System.out.println("8. Contar número de alunos");
            System.out.println("0. Sair");

            int chooseAction = scanner.nextInt();
            int classSize = lp2.countNumberOfStudents();

            switch (chooseAction) {
                case 1:
                    System.out.println("Insira o nome do aluno a ser adicionado: ");
                    String studentName = scanner.next();
                    Student newStudent = new Student(studentName, classSize + 1, cursoSelecionado);
                    lp2.addStudent(newStudent);
                    break;
                case 2:
                    System.out.println("Insira o nome do aluno a ser atualizado: ");
                    String studentUpdate = scanner.next();
                    Student newStudentUpdate = new Student(studentUpdate, classSize + 1, cursoSelecionado);
                    lp2.updateStudent(newStudentUpdate);
                    break;
                case 3:
                    System.out.println("Insira o nome do aluno a ser buscado: ");
                    String searchStudentByName = scanner.next();
                    lp2.getStudentByName(searchStudentByName);
                    break;
                case 4:
                    System.out.println("Insira o ID do aluno a ser buscado: ");
                    int searchStudentById = scanner.nextInt();
                    lp2.getStudentById(searchStudentById);
                    break;
                case 5:
                    System.out.println("Insira o nome do aluno a ser removido: ");
                    String removeStudentByName = scanner.next();
                    lp2.removeStudentByName(removeStudentByName);
                    break;
                case 6:
                    System.out.println("Insira o ID do aluno a ser removido: ");
                    int removeStudentById = scanner.nextInt();
                    lp2.removeStudentById(removeStudentById);
                    break;
                case 7:
                    System.out.println("Insira o nome do aluno a ser validado: ");
                    String validateStudent = scanner.next();
                    Student newValidateStudent = new Student(validateStudent, classSize + 1, cursoSelecionado);
                    lp2.validateStudent(newValidateStudent);
                    break;
                case 8:
                    System.out.println("A classe possui: " + classSize + " alunos.");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}