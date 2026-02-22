interface PricingStrategy{
    public double calculateFare(double distance , double time);
}
class NormalPricing implements PricingStrategy{
    @Override
    public double calculateFare(double distance, double time) {
        double baseFare = 50;
        double distanceFare = distance * 10;
        double timeFare = time*2;
        return (baseFare + distanceFare + timeFare);
    }
}
class SurgePricing implements PricingStrategy{

    @Override
    public double calculateFare(double distance, double time) {
        double baseFare = 50;
        double distanceFare = distance*15;
        double timeFare = time*3;
        double surgeMultiplier = 1.5;
        return (baseFare + distanceFare + timeFare) * surgeMultiplier;
    }
}
class PremiumPricing implements PricingStrategy{
    @Override
    public double calculateFare(double distance, double time) {
        double baseFare= 100;
        double distanceFare = distance*20;
        double timeFare = time*5;
        return baseFare + distanceFare + timeFare;
    }
}
class Ride {
    String rideType;
    private PricingStrategy pricingStrategy;
    Ride(String rideType,PricingStrategy pricingStrategy){
        this.rideType=rideType;
        this.pricingStrategy=pricingStrategy;
    }
    // Improvement 1: Add ability to change strategy at runtime
    //Add this method in Ride:
    public void setPricingStrategy(PricingStrategy pricingStrategy){
        this.pricingStrategy = pricingStrategy;
    }
    public void calculateFare(double distance , double time){
        double fare =pricingStrategy.calculateFare(distance,time);
        System.out.println("Ride type : "+rideType);
        System.out.println("Distance : "+distance);
        System.out.println("Time : "+time);
        System.out.println("Total fare : ₹"+fare);

    }
}
public class UberFareCalculator {
    public static void main(String[] args) {
        Ride miniRide = new Ride("SUV",new NormalPricing());
        miniRide.calculateFare(15,10);
    }
}
