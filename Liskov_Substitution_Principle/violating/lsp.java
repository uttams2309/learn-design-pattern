package violating;

class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }

    public void eat() {
        System.out.println("Bird is eating");
    }
}

class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly!"); // LSP VIOLATION!
    }
}

// Client code
public class lsp {
    public static void makeBirdFly(Bird bird) {
        bird.fly(); // This will crash if bird is a Penguin!
    }

    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        makeBirdFly(sparrow); // Works fine

        Bird penguin = new Penguin();
        makeBirdFly(penguin); // Throws exception - LSP violation!
    }
}

