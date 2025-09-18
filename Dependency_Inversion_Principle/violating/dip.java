package violating;
/*
* DIP violations occur when high level modules depend directly on low level concrete implmentations instead of absrtactions.
* KEY VIOLATION PATTERNS :
* 1. Direct Concrete Dependencies :
*class OrderService {
    private EmailService emailService = new EmailService(); // VIOLATION
    private MySQLDatabase database = new MySQLDatabase();   // VIOLATION
}

*2. Hard coded object creation :
* creating concrete instances inside high level modules
*class PaymentProcessor {
    public void processPayment(double amount) {
        CreditCardPayment payment = new CreditCardPayment(); // VIOLATION
        payment.charge(amount);
    }
}
3. No abstraction layer :
* both modules are concrete classes with no interface / abstractions.
* class ReportGenerator {
    private FileStorage storage; // VIOLATION - concrete class, not interface

    public void generateReport() {
        storage.saveToFile("report.pdf"); // Directly using concrete implementation
    }
}

* CONSEQUENCES OF VIOLATIONS :
* [Tight Coupling, Poor Testability, Reduce Flexibility, Violates OPEN CLOSED PRINCIPLE, Poor Reusability]
*
*
* "DEPENDENCIES SHOULD FLOW TOWARDS ABSTRACTIONS, NOT CONCRETE IMPLEMENTATIONS"
* */







// Low-level modules (concrete implementations)
class EmailService {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}

class DatabaseLogger {
    public void log(String message) {
        System.out.println("Logging to database: " + message);
    }
}


public class dip {
    private EmailService emailService;
    private DatabaseLogger logger;

    public dip() {
        System.out.printf("instance created");
        this.emailService = new EmailService();  // Creating dependencies internally
        this.logger = new DatabaseLogger();
    }

    public void processOrder(String orderId) {
        // Process order logic
        logger.log("Processing order: " + orderId);
        emailService.sendEmail("Order " + orderId + " processed");
    }
    public static void main(String[] args) {
        dip dip = new dip();
        dip.processOrder("1");
        dip dip_1 = new dip();
        dip_1.processOrder("2");
    }
}
