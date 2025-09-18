package following;

import java.util.Arrays;
import java.util.List;

// Abstract base class (or interface)
abstract class Shape {
    public abstract double calculateArea();
    public abstract void draw();
}

// Each shape is a separate class
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle: " + width + "x" + height);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle with radius: " + radius);
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Triangle: " + base + "x" + height);
    }
}

// These classes are now closed for modification
class AreaCalculator {
    public double calculateTotalArea(List<Shape> shapes) {
        return shapes.stream()
                .mapToDouble(Shape::calculateArea)
                .sum();
    }
}

class ShapeDrawer {
    public void drawAllShapes(List<Shape> shapes) {
        shapes.forEach(Shape::draw);
    }
}

// Adding new shape - NO modification to existing classes!
class Pentagon extends Shape {
    private double side;

    public Pentagon(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        // Pentagon area formula
        return (Math.sqrt(25 + 10 * Math.sqrt(5)) / 4) * side * side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Pentagon with side: " + side);
    }
}

// Usage - existing code works with new shapes!
public class ocp {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(
                new Rectangle(5, 10),
                new Circle(7),
                new Triangle(6, 8),
                new Pentagon(4)  // New shape added without modifying existing code!
        );

        AreaCalculator calculator = new AreaCalculator();
        ShapeDrawer drawer = new ShapeDrawer();

        System.out.println("Total area: " + calculator.calculateTotalArea(shapes));
        drawer.drawAllShapes(shapes);
    }
}
