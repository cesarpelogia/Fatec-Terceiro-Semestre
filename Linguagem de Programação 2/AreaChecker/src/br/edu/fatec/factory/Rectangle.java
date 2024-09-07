package br.edu.fatec.factory;

class Rectangle implements Calculable {

    private double largeSize;
    private double smallSize;

    public Rectangle(double largeSize, double smallSize){
        this.largeSize = largeSize;
        this.smallSize = smallSize;
    }

    @Override
    public double calculateArea() {
        return largeSize * smallSize;
    }

    
}