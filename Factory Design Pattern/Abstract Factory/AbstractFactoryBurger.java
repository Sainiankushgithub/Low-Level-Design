interface Burger{
    void prepare();
}
interface Fries{
    void serve();
}
class BasicBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Preparing the basic burger!");
    }
}
class PremiumBurger implements Burger{
    @Override
    public void prepare() {
        System.out.println("Preparing the premium burger!");
    }
}
class PeriPeriFries implements Fries{
    @Override
    public void serve() {
        System.out.println("Preparing the peri peri fries");
    }
}
class CheeseFries implements Fries{
    @Override
    public void serve() {
        System.out.println("Preparing the cheese fries");
    }
}
interface RestaurantFactory{
    Burger createBurger();
    Fries createFries();
}
class BasicBurgerPeriFries implements RestaurantFactory{
    @Override
    public Burger createBurger() {
        return new BasicBurger();
    }
    @Override
    public Fries createFries() {
        return new PeriPeriFries();
    }
}
class PremiumBurgerPeriFries implements RestaurantFactory{
    @Override
    public Burger createBurger() {
        return new PremiumBurger();
    }
    @Override
    public Fries createFries() {
        return new PeriPeriFries();
    }
}
public class AbstractFactoryBurger {
    public static void main(String[] args) {
        RestaurantFactory restaurantFactory = new BasicBurgerPeriFries();
        Burger burger = restaurantFactory.createBurger();
        Fries fries = restaurantFactory.createFries();
        burger.prepare();
        fries.serve();
    }
}
