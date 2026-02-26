interface PaymentProcessor{
    void processPayment(double amount);
}
interface RefundProcessor{
    void processRefund(double amount);
}
class RazorpayPaymentProcessor implements PaymentProcessor{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment via Razorpay: ₹" + amount);
    }
}
class RazorpayRefundProcessor implements RefundProcessor{
    @Override
    public void processRefund(double amount) {
        System.out.println("Processing refund via Razorpay: ₹" + amount);
    }
}
class StripePaymentProcessor implements PaymentProcessor{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment via Stripe: ₹" + amount);
    }
}
class StripeRefundProcessor implements RefundProcessor{
    @Override
    public void processRefund(double amount) {
        System.out.println("Processing refund via Stripe: ₹" + amount);
    }
}
interface PaymentGatewayFactory{
    PaymentProcessor createPaymentProcessor();
    RefundProcessor createRefundProcessor();
}
class RazorpayFactory implements PaymentGatewayFactory{
    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new RazorpayPaymentProcessor();
    }
    @Override
    public RefundProcessor createRefundProcessor() {
        return new RazorpayRefundProcessor();
    }
}
class StripeFactory implements PaymentGatewayFactory{

    @Override
    public PaymentProcessor createPaymentProcessor() {
        return new StripePaymentProcessor();
    }
    @Override
    public RefundProcessor createRefundProcessor() {
        return new StripeRefundProcessor();
    }
}
public class PaymentService {
    public static void main(String[] args) {
        PaymentGatewayFactory paymentGatewayFactory = new RazorpayFactory();
        PaymentProcessor paymentProcessor=paymentGatewayFactory.createPaymentProcessor();
        RefundProcessor refundProcessor = paymentGatewayFactory.createRefundProcessor();
        paymentProcessor.processPayment(5000);
        refundProcessor.processRefund(4000);
    }
}
