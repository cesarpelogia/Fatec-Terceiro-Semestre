package br.edu.school.factory;



public interface StudentOperations {
    
    public int numberOfStudents(){
        return students.length;
    }

    public void addStudent(Student student) {
        if (students.length < numberOfStudents()) {

        } else {
            System.out.println("A sala de aula está cheia.");
        }
    }
    
    public void updateStudent(Student updateStudent) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getStudentId() == updateStudent.getStudentId()) {
                students[i] = updateStudent;
                System.out.println("Aluno " + updateStudent.getName() + " atualizado com sucesso.");
                return;
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
                // Desloca os alunos à esquerda
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


}
