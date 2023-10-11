package main;

import main.strategyPattern.Duck;
import main.strategyPattern.MallardDuck;
import main.strategyPattern.RubberDuck;
import main.strategyPattern.WoodenDuck;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Duck> ducks = new ArrayList<>();

        Duck mallardDuck = new MallardDuck();
        Duck rubberDuck = new RubberDuck();
        Duck woodenDuck = new WoodenDuck();

        ducks.add(mallardDuck);
        ducks.add(rubberDuck);
        ducks.add(woodenDuck);

        for (Duck duck : ducks) {
            duck.display();
            duck.performFly();
            duck.performQuack();
            duck.performEat();
            System.out.println();
        }
    }
}