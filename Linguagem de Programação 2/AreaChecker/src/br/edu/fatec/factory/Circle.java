package br.edu.fatec.factory;

public class Circle implements Calculable {

    double radius;
    double pi = 3.1415;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return pi * (radius * radius);
    }
}