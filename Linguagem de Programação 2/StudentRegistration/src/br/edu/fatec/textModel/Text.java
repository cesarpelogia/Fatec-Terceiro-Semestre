package br.edu.fatec.textModel;

public class Text {

    private int grade;
    private int weight;
    
    public Text (int grade, int weight){
        this.grade = grade;
        this.weight = weight;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
