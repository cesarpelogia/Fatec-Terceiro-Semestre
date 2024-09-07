package br.edu.fatec.factory;

class Triangle implements Calculable {
    
    private double high;
    private double base;

    public Triangle(double base, double high){
        this.base = base;
        this.high = high;
    }

    @Override
    public double calculateArea(){
        return (base * high) / 2;
    }

}
