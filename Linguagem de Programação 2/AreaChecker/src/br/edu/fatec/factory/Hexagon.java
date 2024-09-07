package br.edu.fatec.factory;

public class Hexagon implements Calculable {

    private double size;

    public Hexagon(double size){
        this.size = size;
    }

    @Override
    public double calculateArea() {
        return ((3 * Math.sqrt(3)) / size * size);
    }
}
