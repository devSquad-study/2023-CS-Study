import duck.*;

public class Main {

    public static void main(String[] args) {
        Duck duck = new Duck();
        Duck decoyDuck = new DecoyDuck();
        Duck mallardDuck = new MallardDuck();
        Duck redheadDuck = new RedheadDuck();
        Duck rubberDuck = new RubberDuck();

        duck.performQuack();
        decoyDuck.performQuack();
        mallardDuck.performQuack();
        redheadDuck.performQuack();
        rubberDuck.performQuack();
    }
}
