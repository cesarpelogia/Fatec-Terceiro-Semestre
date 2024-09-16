package br.edu.school.factory;

public class Exam {
    
    private int note;
    private int weight;

    public Exam(int note, int weight){
        this.note = note;
        this.weight = weight;
    }

    public void setNote(int note){
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
}
