package br.edu.fatec.factory;

public class Parallelogram implements Calculable {
    
    private double base;
    private double high;

    public Parallelogram(Double base, Double high){
        this.base = base;
        this.high = high;
    }

    @Override
    public double calculateArea(){
        return base * high;
    }
}
