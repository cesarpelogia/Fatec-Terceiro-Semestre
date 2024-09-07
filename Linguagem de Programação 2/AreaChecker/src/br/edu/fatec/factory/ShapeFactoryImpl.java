package br.edu.fatec.factory;

public class ShapeFactoryImpl implements ShapeFactory{

    Calculable result = null;
    
    @Override
    public Calculable getShape(ShapeType type, Double[] values) {
        switch (type) {
            case Square:
                return new Square(values[0]);
            case Rectangle:
                return new Rectangle(values [0], values[1]);
            case Circle:
                return new Circle(values[0]);
            case Triangle:
                return new Triangle(values[0], values[1]);
            case Parallelogram:
                return new Parallelogram(values[0],values[1]);
            case Trapezium:
                return new Trapezium(values[0],values[1],values[2]);
            case Hexagon:
                return new Hexagon(values[0]);
            case Diamond:
                return new Diamond(values[0],values[1]);
            case Cube:
                return new Cube(values[0]);
        }
        return result;
    }
}
