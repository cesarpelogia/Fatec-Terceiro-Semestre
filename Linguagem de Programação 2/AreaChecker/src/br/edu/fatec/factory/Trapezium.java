package br.edu.fatec.factory;

class Trapezium implements Calculable {

    private double largeBase;
    private double smallBase;
    private double high;

    public Trapezium(Double largeBase, Double smallBase, Double high){

        this.largeBase = largeBase;
        this.smallBase = smallBase;
        this.high = high;
    }

    @Override
    public double calculateArea() {
        return ((largeBase * smallBase) * high ) / 2;
    }
}
