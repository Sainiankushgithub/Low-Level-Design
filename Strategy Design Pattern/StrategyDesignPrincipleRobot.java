//  Strategy Interface for walk
interface WalkableRobot{
    public void walk();
}
class NormalWalk implements WalkableRobot{

    @Override
    public void walk() {
        System.out.println("Normal walking . . . . . ");
    }
}
class NoWalk implements WalkableRobot{
    @Override
    public void walk(){

    }
}
//  Strategy Interface for Fly
interface FlyableRobot{
    public void fly();
}
class NormalFly implements FlyableRobot{
    @Override
    public void fly() {
        System.out.println("Normal Flying robot . . . . ");
    }
}
class NoFly implements FlyableRobot{
    @Override
    public void fly(){
        System.out.println("No Flying robot . . . . . ");
    }
}
//  Strategy Interface for Talk
interface TalkableRobot{
    public void talk();
}
class NormalTalk implements TalkableRobot{
    @Override
    public void talk() {
        System.out.println("Normal talking robot . . . . .");
    }
}
class NoTalk implements TalkableRobot{
    @Override
    public void talk() {
        System.out.println("No talk robot . . . . . ");
    }
}
// Robot Base class
abstract class Robot{
    private WalkableRobot walkableRobot;
    private TalkableRobot talkableRobot;
    private FlyableRobot flyableRobot;

    public Robot(WalkableRobot walkableRobot,TalkableRobot talkableRobot
            ,FlyableRobot flyableRobot){
        this.walkableRobot = walkableRobot;
        this.talkableRobot = talkableRobot;
        this.flyableRobot = flyableRobot;
    }
    public void walk(){
        walkableRobot.walk();
    }
    public void talk(){
        talkableRobot.talk();
    }
    public void fly(){
        flyableRobot.fly();
    }
    public abstract void projection();
}
// Concrete Robot types
class CompanionRobot extends Robot{

    public CompanionRobot(WalkableRobot walkableRobot, TalkableRobot talkableRobot, FlyableRobot flyableRobot) {
        super(walkableRobot, talkableRobot, flyableRobot);
    }

    @Override
    public void projection() {
        System.out.println("Displaying friendly companion features...");
    }
}
class WorkerRobot extends Robot{

    public WorkerRobot(WalkableRobot walkableRobot, TalkableRobot talkableRobot, FlyableRobot flyableRobot) {
        super(walkableRobot, talkableRobot, flyableRobot);
    }

    @Override
    public void projection() {
        System.out.println("Displaying worker efficiency stats...");
    }
}
public class StrategyDesignPrincipleRobot {
    public static void main(String[] args) {
        Robot robot1 = new CompanionRobot(new NormalWalk(),new NormalTalk(), new NoFly());
        robot1.fly();
        robot1.talk();
        robot1.walk();
        robot1.projection();

        System.out.println("--------------------");

        Robot robot2 = new WorkerRobot(new NoWalk(), new NoTalk(), new NormalFly());
        robot2.walk();
        robot2.talk();
        robot2.fly();
        robot2.projection();
    }
}
