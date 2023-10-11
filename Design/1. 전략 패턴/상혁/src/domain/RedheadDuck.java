package domain;

import strategies.fly.FlyRocketPowered;
import strategies.quack.Quack;

public class RedheadDuck extends Duck {
    public RedheadDuck() {
        flyBehavior = new FlyRocketPowered();
        quackBehavior = new Quack();
    }

    @Override
    public Duck display() {
        System.out.println("저는 아메리칸흰죽지 오리 입니다");
        return this;
    }
}
