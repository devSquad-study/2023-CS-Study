package main.strategyPattern;

import main.strategyPattern.eatbehavior.CannotEat;
import main.strategyPattern.flybehavior.FlyNoWay;
import main.strategyPattern.quackbehavior.MuteQuack;
import main.strategyPattern.quackbehavior.Sqeak;

public class RobotDuck extends Duck{

    public RobotDuck() {
        quackBehavior = new MuteQuack();
        flyBehavior = new FlyNoWay();
        eatBehavior = new CannotEat();
    }
    @Override
    public void display() {
        System.out.println("저는 로봇 오리입니다.");
    }
}
