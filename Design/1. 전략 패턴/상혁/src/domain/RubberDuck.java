package domain;

import strategies.fly.FlyNoWay;
import strategies.quack.Squeak;

public class RubberDuck extends Duck {
    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }

    @Override
    public Duck display() {
        System.out.println("저는 고무 오리 입니다");
        return this;
    }
}
