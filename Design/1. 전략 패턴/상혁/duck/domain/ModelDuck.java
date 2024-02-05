package domain;

import strategies.fly.FlyNoWay;
import strategies.quack.Quack;

public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public Duck display() {
        System.out.println("저는 모형 오리 입니다");
        return this;
    }
}
