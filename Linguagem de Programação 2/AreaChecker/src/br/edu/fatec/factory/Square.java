package br.edu.fatec.factory;

class Square implements Calculable {
    
    private double size;

    public Square(double size) {
        this.size = size;
    }

    @Override
    public double calculateArea(){
        return size * size;
    }
}
