import br.edu.fatec.classroomModel.Classroom;
import br.edu.fatec.schoolModel.Student;
import br.edu.fatec.textModel.Text;

public class Main {
    public static void main(String[] args) {
        Classroom classroom = new Classroom("Linguagem de Programação II", 5);

        classroom.addStudent(1, "Alice", "Linguagem de Programação II");
        classroom.addStudent(2, "Bruno", "Linguagem de Programação II");

        classroom.printAllStudents();

        classroom.updateStudent(1, "Alice Silva", "Linguagem de Programação II");

        Student alice = classroom.getStudentById(1);
        

        Text text = new Text(90, 5);
        boolean result = classroom.addTextToStudent(alice, text);
        
        if (result) {
            System.out.println("Nota adicionada com sucesso para " + alice.getStudentName());
        } else {
            System.out.println("Falha ao adicionar a nota.");
        }

        classroom.getStudentByName("Bruno");
        classroom.getStudentById(1);

        classroom.deleteStudentByName("Alice Silva");

        classroom.printAllStudents();
    }
}
