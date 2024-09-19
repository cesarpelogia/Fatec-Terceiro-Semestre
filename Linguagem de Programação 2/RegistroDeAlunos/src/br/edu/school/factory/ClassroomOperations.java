package br.edu.school.factory;

public class ClassroomOperations {
    
    public int countNumberOfStudents() {
        int currentNumberOfStudents = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null){
            currentNumberOfStudents++;
            }
        }
        System.out.println("O número de alunos é: " + currentNumberOfStudents);
        return currentNumberOfStudents;
    }
}
