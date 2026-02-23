class IllegalBurgerException extends Exception{
    IllegalBurgerException(String msg){
        super(msg);
    }
}
interface Burger{
    void prepare();
}
class BasicBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing the Basic burger!");
    }
}
class StandardBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing the Standard burger!");
    }
}
class PremiumBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing the Premium burger!");
    }
}
interface BurgerFactory{
    Burger createBurger(String type) throws Exception;
}
class BurgerKing implements BurgerFactory{

    @Override
    public Burger createBurger(String type) throws Exception{
        if(type.equalsIgnoreCase("BASIC")){
            return new BasicBurger();
        }else if(type.equalsIgnoreCase("STANDARD")){
            return new StandardBurger();
        }else if(type.equalsIgnoreCase("PREMIUM")){
            return new PremiumBurger();
        }else{
            throw new IllegalBurgerException("Invalid Burger type Exception");
        }
    }
}
class BurgerSingh implements BurgerFactory{
    @Override
    public Burger createBurger(String type) throws Exception {
        if(type.equalsIgnoreCase("BASIC")){
            return new BasicBurger();
        }else if(type.equalsIgnoreCase("STANDARD")){
            return new StandardBurger();
        }else if(type.equalsIgnoreCase("PREMIUM")){
            return new PremiumBurger();
        }else{
          throw new IllegalBurgerException("Invalid Burger type Exception");
        }
    }
}
public class FactoryMethodBurger {
    public static void main(String[] args) throws Exception {
        BurgerFactory burgerFactory = new BurgerKing();
        Burger burger = burgerFactory.createBurger("Basic");
        burger.prepare();
    }
}
