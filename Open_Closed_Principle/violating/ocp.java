package violating;

// Enum for shape types
enum ShapeType {
    RECTANGLE, CIRCLE, TRIANGLE
}

class Shape {
    private ShapeType type;
    private double width, height, radius;

    public Shape(ShapeType type, double width, double height) {
        this.type = type;
        this.width = width;
        this.height = height;
    }

    public Shape(ShapeType type, double radius) {
        this.type = type;
        this.radius = radius;
    }

    // Getters
    public ShapeType getType() { return type; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public double getRadius() { return radius; }
}

// This class violates OCP
class AreaCalculator {
    public double calculateArea(Shape shape) {
        switch (shape.getType()) {
            case RECTANGLE:
                return shape.getWidth() * shape.getHeight();
            case CIRCLE:
                return Math.PI * shape.getRadius() * shape.getRadius();
            case TRIANGLE:
                return 0.5 * shape.getWidth() * shape.getHeight();
            default:
                throw new IllegalArgumentException("Unknown shape type");
        }
    }
}

// This class also violates OCP
class ShapeDrawer {
    public void drawShape(Shape shape) {
        switch (shape.getType()) {
            case RECTANGLE:
                System.out.println("Drawing Rectangle: " + shape.getWidth() + "x" + shape.getHeight());
                break;
            case CIRCLE:
                System.out.println("Drawing Circle with radius: " + shape.getRadius());
                break;
            case TRIANGLE:
                System.out.println("Drawing Triangle: " + shape.getWidth() + "x" + shape.getHeight());
                break;
            default:
                throw new IllegalArgumentException("Unknown shape type");
        }
    }
}
