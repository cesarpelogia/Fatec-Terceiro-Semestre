package br.edu.fatec.main;

import br.edu.fatec.factory.Calculable;
import br.edu.fatec.factory.ShapeFactoryImpl;
import br.edu.fatec.factory.ShapeType;

public class Main {
    public static void main(String[] args) {
        ShapeFactoryImpl shapeFactoryImpl = new ShapeFactoryImpl();

        Calculable square = shapeFactoryImpl.getShape(ShapeType.Square, new Double[]{5.0});
        Calculable rectangle = shapeFactoryImpl.getShape(ShapeType.Rectangle, new Double[]{5.0, 10.0});
        Calculable circle = shapeFactoryImpl.getShape(ShapeType.Circle, new Double[]{7.0});
        Calculable triangle = shapeFactoryImpl.getShape(ShapeType.Triangle, new Double[]{5.0, 10.0});
        Calculable parallelogram = shapeFactoryImpl.getShape(ShapeType.Parallelogram, new Double[]{5.0, 10.0});
        Calculable trapezium = shapeFactoryImpl.getShape(ShapeType.Trapezium, new Double[]{5.0, 10.0, 7.0});
        Calculable hexagon = shapeFactoryImpl.getShape(ShapeType.Hexagon, new Double[]{6.0});
        Calculable diamond = shapeFactoryImpl.getShape(ShapeType.Diamond, new Double[]{5.0, 8.0});
        Calculable cube = shapeFactoryImpl.getShape(ShapeType.Cube, new Double[]{4.0});

        System.out.println("Square area: " + square.calculateArea());
        System.out.println("Rectangle area: " + rectangle.calculateArea());
        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Triangle area: " + triangle.calculateArea());
        System.out.println("Parallelogram area: " + parallelogram.calculateArea());
        System.out.println("Trapezium area: " + trapezium.calculateArea());
        System.out.println("Hexagon area: " + hexagon.calculateArea());
        System.out.println("Diamond area: " + diamond.calculateArea());
        System.out.println("Cube area: " + cube.calculateArea());
    }
}
