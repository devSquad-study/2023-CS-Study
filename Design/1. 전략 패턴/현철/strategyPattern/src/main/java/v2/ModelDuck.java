package v2;

import v2.interfaceMass.fly.FlyNoWay;
import v2.interfaceMass.quack.Quack;

public class ModelDuck extends Duck{
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("모형 오리");
    }
}
