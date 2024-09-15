package br.edu.school.model;

public class Classroom {

    private String className;
    private Student[] students;

    public Classroom(String className, int capacity) {
        this.className = className;
        this.students = new Student[capacity];
    }

    public void setClassName(String className){
        this.className = className;
    }
    
    public String getClassName(){
        return className;
    }

    public Student addStudent(Student student) {
        for (int i = 0; i < students.length; i++){
            if (students[i] == null){
                students[i] = student;
                System.out.println("Aluno "+ students[i].getName() + " adicionado com sucesso");
            }
        }
        throw new IllegalStateException("Não foi possível adicionar o aluno: a sala de aula está cheia.");
    }
    
    public void updateStudent(Student updateStudent) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getStudentId() == updateStudent.getStudentId()) {
                students[i] = updateStudent;
                System.out.println("Aluno " + updateStudent.getName() + " atualizado com sucesso.");
            }
        }
        throw new IllegalStateException("Não foi encontrado o aluno");
    }

    public Student getStudentByName(String name){
        for (Student student : students) {
            if (student != null && student.getName().equals(name)){
                return student;
            }
        }
        throw new IllegalStateException("Aluno não encontrado.");
    }

    public Student getStudentById(int studentId) {
        for (Student student : students) {
            if (student != null && student.getStudentId() == studentId) {
                return student;
            }
        }
        throw new IllegalStateException("Aluno não encontrado.");
    }

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
        throw new IllegalStateException("Não foi possível remover o aluno.");
    }

    public boolean validateStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getStudentId() == student.getStudentId()) {
                return false;
            }
        }
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return true;
            }
        }
        return false;
    }

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
        throw new IllegalStateException("Não foi possível remover o aluno.");
    }

    public int countNumberOfStudents(Classroom className){
        int currenteNumberOfStudents = 0;
        for(int i = 0; i > students.length; i++){
            currenteNumberOfStudents++;
        }
        return currenteNumberOfStudents;
    }
}
