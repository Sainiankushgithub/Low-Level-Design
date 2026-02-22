// strategy Design pattern for UPI
interface PaymentStrategy{
    public void payment();
}
class BhimUpi implements PaymentStrategy{
    @Override
    public void payment(){
        System.out.println("Doing payment through bhim upi");
    }
}
class PhonePay implements PaymentStrategy{

    @Override
    public void payment() {
        System.out.println("Doing payment through Phone pay upi");
    }
}
class Paytm implements PaymentStrategy{

    @Override
    public void payment() {
        System.out.println("Doing payment through paytm upi");
    }
}
class HdfcDebitCard implements PaymentStrategy{

    @Override
    public void payment() {
        System.out.println("Doing payment through Hdfc Debit card");
    }
}
class SbiDebitCard implements PaymentStrategy{

    @Override
    public void payment() {
        System.out.println("Doing payment through Sbi debit card");
    }
}
class PaymentService{
    private PaymentStrategy paymentStrategy;
    public PaymentService (PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }
    public void payment(){
        paymentStrategy.payment();
    }
}
public class StrategyDesignPatternUPI {
    public static void main(String[] args) {
        PaymentService payment1 = new PaymentService(new HdfcDebitCard());
        payment1.payment();
        PaymentService payment2 = new PaymentService(new PhonePay());
        payment2.payment();
    }
}

