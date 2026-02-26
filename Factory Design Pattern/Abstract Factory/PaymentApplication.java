// =======================
// STRATEGY PATTERN
// =======================

// Strategy Interface: defines HOW payment is done
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategy 1
class UPIPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paying using UPI: ₹" + amount);
    }
}

// Concrete Strategy 2
class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paying using Card: ₹" + amount);
    }
}


// =======================
// ABSTRACT FACTORY PATTERN
// =======================

// Abstract Product 1
interface PaymentProcessor {
    void processPayment(double amount);
}

// Abstract Product 2
interface RefundProcessor {
    void processRefund(double amount);
}


// =======================
// RAZORPAY FAMILY (Concrete Products)
// =======================

class RazorpayPaymentProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Razorpay processing payment: ₹" + amount);
    }
}

class RazorpayRefundProcessor implements RefundProcessor {

    @Override
    public void processRefund(double amount) {
        System.out.println("Razorpay processing refund: ₹" + amount);
    }
}


// =======================
// STRIPE FAMILY (Concrete Products)
// =======================

class StripePaymentProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Stripe processing payment: ₹" + amount);
    }
}

class StripeRefundProcessor implements RefundProcessor {

    @Override
    public void processRefund(double amount) {
        System.out.println("Stripe processing refund: ₹" + amount);
    }
}


// =======================
// ABSTRACT FACTORY
// =======================

interface PaymentGatewayFactory {

    PaymentProcessor createPaymentProcessor();

    RefundProcessor createRefundProcessor();
}


// =======================
// CONCRETE FACTORIES
// =======================

// Razorpay Factory
class RazorpayFactory implements PaymentGatewayFactory {

    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new RazorpayPaymentProcessor();
    }

    @Override
    public RefundProcessor createRefundProcessor() {
        return new RazorpayRefundProcessor();
    }
}


// Stripe Factory
class StripeFactory implements PaymentGatewayFactory {

    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new StripePaymentProcessor();
    }

    @Override
    public RefundProcessor createRefundProcessor() {
        return new StripeRefundProcessor();
    }
}


// =======================
// FACTORY METHOD PATTERN
// =======================

// Factory Creator: decides WHICH factory to use
class PaymentGatewayFactoryCreator {

    public static PaymentGatewayFactory getFactory(String gatewayType) {

        if (gatewayType.equalsIgnoreCase("RAZORPAY")) {
            return new RazorpayFactory();
        }
        else if (gatewayType.equalsIgnoreCase("STRIPE")) {
            return new StripeFactory();
        }

        throw new IllegalArgumentException("Invalid gateway type");
    }
}


// =======================
// CONTEXT CLASS (Uses Strategy)
// =======================

class PaymentService {

    private PaymentStrategy paymentStrategy;
    private PaymentProcessor paymentProcessor;
    private RefundProcessor refundProcessor;

    public PaymentService(PaymentStrategy paymentStrategy,
                          PaymentProcessor paymentProcessor,
                          RefundProcessor refundProcessor) {

        this.paymentStrategy = paymentStrategy;
        this.paymentProcessor = paymentProcessor;
        this.refundProcessor = refundProcessor;
    }

    public void makePayment(double amount) {

        // Strategy Pattern execution
        paymentStrategy.pay(amount);

        // Abstract Factory Product execution
        paymentProcessor.processPayment(amount);
    }

    public void refundPayment(double amount) {

        refundProcessor.processRefund(amount);
    }
}


// =======================
// MAIN CLASS (CLIENT)
// =======================

public class PaymentApplication {

    public static void main(String[] args) {

        // Step 1: Factory Method selects factory
        PaymentGatewayFactory factory =
                PaymentGatewayFactoryCreator.getFactory("RAZORPAY");

        // Step 2: Abstract Factory creates related objects
        PaymentProcessor paymentProcessor =
                factory.createPaymentProcessor();

        RefundProcessor refundProcessor =
                factory.createRefundProcessor();

        // Step 3: Strategy Pattern selects payment method
        PaymentStrategy strategy =
                new UPIPaymentStrategy();

        // Step 4: Context uses all
        PaymentService paymentService =
                new PaymentService(strategy, paymentProcessor, refundProcessor);

        // Make payment
        paymentService.makePayment(1000);

        System.out.println();

        // Refund payment
        paymentService.refundPayment(500);
    }
}