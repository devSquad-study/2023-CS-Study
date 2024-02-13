package domain;

import strategies.fly.FlyNoWay;
import strategies.quack.MuteQuack;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    public Duck display() {
        System.out.println("저는 가짜 오리 입니다");
        return this;
    }

}
