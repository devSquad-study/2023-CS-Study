package main.strategyPattern;

import main.strategyPattern.eatbehavior.CannotEat;
import main.strategyPattern.eatbehavior.EatingBehavior;
import main.strategyPattern.flybehavior.FlyNoWay;
import main.strategyPattern.quackbehavior.Sqeak;

public class RubberDuck extends Duck{

    public RubberDuck() {
        quackBehavior = new Sqeak();
        flyBehavior = new FlyNoWay();
        eatBehavior = new CannotEat();
    }
    @Override
    public void display() {
        System.out.println("저는 고무 오리입니다.");
    }
}
