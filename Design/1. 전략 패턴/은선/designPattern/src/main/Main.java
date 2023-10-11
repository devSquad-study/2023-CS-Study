package main;

import main.strategyPattern.*;
import main.strategyPattern.flybehavior.FlyRocketPowered;
import main.strategyPattern.quackbehavior.Sqeak;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Duck> ducks = new ArrayList<>();

        Duck mallardDuck = new MallardDuck();
        Duck rubberDuck = new RubberDuck();
        Duck woodenDuck = new WoodenDuck();
        Duck robotDuck = new RobotDuck();

        ducks.add(mallardDuck);
        ducks.add(rubberDuck);
        ducks.add(woodenDuck);
        ducks.add(robotDuck);

        robotDuck.setFlyBehavior(new FlyRocketPowered());

        for (Duck duck : ducks) {
            duck.display();
            duck.performFly();
            duck.performQuack();
            duck.performEat();
            System.out.println();
        }
    }
}
