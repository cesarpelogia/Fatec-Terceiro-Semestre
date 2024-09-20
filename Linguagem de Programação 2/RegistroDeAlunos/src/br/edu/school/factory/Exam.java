package br.edu.school.factory;

public class Exam {
    
    private int note;
    private int weight;
    private ExamStatus status;

    public Exam(int note, int weight){
        this.note = note;
        this.weight = weight;
        this.status = calculatestatus();
    }

    public ExamStatus calculatestatus(){
        if (note >= 6){
            return ExamStatus.APROVADO;
        } else if (note == 0){
            return ExamStatus.EM_ANDAMNETO;
        } else {
            return ExamStatus.REPROVADO;
        }
    }

    public ExamStatus getExamStatus(){
        return status;
    }
    
    public void setNote(int note){
        if(note < 0 || note > 10){
            System.out.println("Nota fora dos parâmetros estabelecidos (0 até 10)");
        }
        this.note = note;
    }

    public int getNote(){
        return note;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }

    public double getWeightedNote(){
        return (note * weight) / 100;
    }
}
