package domain;

import strategies.fly.FlyWithWings;
import strategies.quack.Quack;

public class MallardDuck extends Duck{
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public Duck display() {
        System.out.println("저는 청둥 오리 입니다");
        return this;
    }
}
