package br.edu.fatec.factory;

public class Diamond implements Calculable {

    private double largeDiagonal;
    private double smallDiagonal;

    public Diamond (Double largeDiagonal, Double smallDiagonal){
        this.largeDiagonal = largeDiagonal;
        this.smallDiagonal = smallDiagonal;
    }

    @Override
    public double calculateArea() {
        return (largeDiagonal * smallDiagonal) / 2;
    }
}