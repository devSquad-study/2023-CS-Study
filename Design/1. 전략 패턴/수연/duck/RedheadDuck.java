package duck;

import fly.FlyWithWings;
import quack.Quack;

//빨간머리오리
public class RedheadDuck extends Duck{
    public RedheadDuck(){
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.println("빨간오리");
    }
}
