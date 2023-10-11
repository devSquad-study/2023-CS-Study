package main.strategyPattern;

import main.strategyPattern.eatbehavior.CanEat;
import main.strategyPattern.eatbehavior.EatingBehavior;
import main.strategyPattern.flybehavior.FlyWithWings;
import main.strategyPattern.quackbehavior.Quack;

public class MallardDuck extends Duck{

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
        eatBehavior = new CanEat();
    }

    @Override
    public void display() {
        System.out.println("저는 물오리입니다.");
    }
}
