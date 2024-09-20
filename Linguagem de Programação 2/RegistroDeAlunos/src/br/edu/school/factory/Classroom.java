package br.edu.school.factory;

public class Classroom implements StudentOperations {

    private Course course;
    private Student[] students;

    public Classroom(Course course, int capacity) {
        this.course = course;
        this.students = new Student[capacity];
    }

    @Override
    public int numberOfStudents() {
        int counter = 0;
        for (Student student : students) {
            if (student != null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public int capacityOfStudents() {
        return students.length;
    }

    @Override
    public Course getCourse() {
        return course;
    }

    @Override
    public void addStudent(Student student) {
        if (validateStudent(student)) {
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = student;
                    System.out.println("Aluno " + student.getName() + " adicionado com sucesso!");
                    return;
                }
            }
        } else {
            System.out.println("Aluno com matrícula " + student.getStudentId() + " já existe.");
        }
        System.out.println("A sala de aula está cheia ou o aluno já foi adicionado.");
    }

    @Override
    public void updateStudent(Student updateStudent) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getStudentId() == updateStudent.getStudentId()) {
                students[i] = updateStudent;
                System.out.println("Aluno " + updateStudent.getName() + " atualizado com sucesso.");
                return;
            }
        }
    }

    @Override
    public Student getStudentById(int studentId) {
        for (Student student : students) {
            if (student != null && student.getStudentId() == studentId) {
                return student;
            }
        }
        System.out.println("Aluno não encontrado");
        return null;
    }

    @Override
    public Student getStudentByName(String name) {
        for (Student student : students) {
            if (student != null && student.getName().equals(name)) {
                return student;
            }
        }
        System.err.println("Aluno não encontrado");
        return null;
    }

    @Override
    public boolean removeStudentByName(String name) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getName().equals(name)) {
                for (int j = i; j < students.length - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[students.length - 1] = null;
                System.out.println("Aluno removido com sucesso!");
                return true;
            }
        }
        System.out.println("Aluno não encontrado.");
        return false;
    }

    @Override
    public boolean removeStudentById(int studentId) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getStudentId() == studentId) {
                for (int j = i; j < students.length - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[students.length - 1] = null;
                System.out.println("Aluno removido com sucesso!");
                return true;
            }
        }
        System.out.println("Aluno não encontrado.");
        return false;
    }

    @Override
    public boolean validateStudent(Student student) {
        for (Student s : students) {
            if (s != null && s.getStudentId() == student.getStudentId()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeExam(Student student, int examIndex) {
        if (examIndex < 0 || examIndex >= student.getExams().length || student.getExams()[examIndex] == null) {
            System.out.println("Índice inválido ou exame não encontrado.");
            return false;
        }
        student.getExams()[examIndex] = null;
        System.out.println("Exame removido com sucesso!");
        return true;
    }

    @Override
    public Exam[] getExams(Student student) {
        return student.getExams();
    }

    public void addExam(Student student, Exam exam) {
        if (student.addExamStudent(exam)) {
            System.out.println("Exame adicionado com sucesso.");
        } else {
            System.out.println("Não foi possível adicionar o exame. O array de exames está cheio.");
        }
    }
}
