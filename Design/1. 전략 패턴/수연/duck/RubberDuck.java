package duck;

import fly.FlyNoWay;
import quack.Squeak;

//고무오리
public class RubberDuck extends Duck{
    public RubberDuck(){
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new Squeak());
    }

    @Override
    public void display() {
        System.out.println("고무오리");
    }
}
