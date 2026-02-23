import java.util.Scanner;

interface Burger{
    void prepare();
}
class BasicBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing the Basic burger with bun and patty !");
    }
}
class StandardBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing the Standard burger with bun, patty, cheese and lettuce !");
    }
}
class PremiumBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing the Premium burger with bun, patty , cheese and secret sauce !");
    }
}
class BurgerFactory{
    public static Burger createBurger(String type){
        if(type.trim().equalsIgnoreCase("BASIC")){
            return new BasicBurger();
        } else if (type.trim().equalsIgnoreCase("STANDARD")) {
            return new StandardBurger();
        }
        else if(type.trim().equalsIgnoreCase("PREMIUM")){
            return new PremiumBurger();
        } else{
            System.out.println("Invalid burger type!");
            return null;
        }
    }
}
public class SimpleFactoryDesignPatternBurger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the burger type given below : ");
        System.out.println("1. Basic \n2. Standard \n3. Premium");
        String type = sc.nextLine();
        Burger burger = BurgerFactory.createBurger(type);
        burger.prepare();
    }
}
