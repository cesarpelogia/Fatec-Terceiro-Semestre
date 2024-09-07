package br.edu.fatec.factory;

public class Cube implements Calculable {

    private double size;

    public Cube(Double size) {
        this.size = size;
    }

    @Override
    public double calculateArea() {
        return 6 * (size * size);

    }
    
}