package duck;

import fly.FlyWithWings;
import quack.Quack;

// 물오리
public class MallardDuck extends Duck{

    public MallardDuck(){
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.println("물오리");
    }
}
