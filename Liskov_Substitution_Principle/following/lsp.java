package following;
/*
Subclasses must be substitutable for their base classes without causing unexpected behaviour.

* */
// Base class for all birds
abstract class Bird {
    public abstract void eat();
}

// Interface for flying behavior
interface Flyable {
    void fly();
}

// Interface for swimming behavior
interface Swimmable {
    void swim();
}

// Sparrow can fly
class Sparrow extends Bird implements Flyable {
    @Override
    public void eat() {
        System.out.println("Sparrow is eating seeds");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

// Penguin can swim but not fly
class Penguin extends Bird implements Swimmable {
    @Override
    public void eat() {
        System.out.println("Penguin is eating fish");
    }

    @Override
    public void swim() {
        System.out.println("Penguin is swimming");
    }
}

// Eagle can fly
class Eagle extends Bird implements Flyable {
    @Override
    public void eat() {
        System.out.println("Eagle is eating prey");
    }

    @Override
    public void fly() {
        System.out.println("Eagle is soaring high");
    }
}

// Client code respects capabilities
public class lsp {
    public static void feedBird(Bird bird) {
        bird.eat(); // All birds can eat
    }

    public static void makeFlyableBirdFly(Flyable flyable) {
        flyable.fly(); // Only flyable birds can fly
    }

    public static void makeSwimmableBirdSwim(Swimmable swimmable) {
        swimmable.swim(); // Only swimmable birds can swim
    }

    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird penguin = new Penguin();
        Bird eagle = new Eagle();

        // All birds can eat - LSP maintained
        feedBird(sparrow);
        feedBird(penguin);
        feedBird(eagle);

        // Only flyable birds fly - no LSP violation
        makeFlyableBirdFly((Flyable) sparrow);
        makeFlyableBirdFly((Flyable) eagle);
        // makeFlyableBirdFly((Flyable) penguin); // Compiler error - good!

        // Only swimmable birds swim
        makeSwimmableBirdSwim((Swimmable) penguin);
    }
}

