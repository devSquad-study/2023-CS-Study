package v2;

import v2.interfaceMass.fly.FlyNoWay;
import v2.interfaceMass.fly.FlyWithWings;
import v2.interfaceMass.quack.Quack;

// 생성자를 통해 구현되어 있는 구상 클래스의 인스턴를 만들어 사용.

public class MallardDuck extends Duck{

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("물오리");
    }
}
