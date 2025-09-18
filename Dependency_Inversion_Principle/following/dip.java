package following;

// Abstractions (interfaces)
interface NotificationService {
    void sendNotification(String message);
}

interface Logger {
    void log(String message);
}

// Low-level modules implementing abstractions
class EmailService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SMSService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class DatabaseLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Logging to database: " + message);
    }
}

class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Logging to file: " + message);
    }
}

// High-level module depending on abstractions
class OrderProcessor {
    private final NotificationService notificationService;
    private final Logger logger;

    // Dependencies injected through constructor
    public OrderProcessor(NotificationService notificationService, Logger logger) {
        this.notificationService = notificationService;
        this.logger = logger;
    }

    public void processOrder(String orderId) {
        // Process order logic
        logger.log("Processing order: " + orderId);
        notificationService.sendNotification("Order " + orderId + " processed");
    }
}

// Usage
public class dip {
    public static void main(String[] args) {
        // Can easily switch implementations
        NotificationService emailService = new EmailService();
        Logger fileLogger = new FileLogger();

        OrderProcessor processor = new OrderProcessor(emailService, fileLogger);
        processor.processOrder("12345");

        // Or use different implementations
        NotificationService smsService = new SMSService();
        Logger dbLogger = new DatabaseLogger();

        OrderProcessor processor2 = new OrderProcessor(smsService, dbLogger);
        processor2.processOrder("67890");
    }
}
