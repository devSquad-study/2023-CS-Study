package duck;

import fly.FlyNoWay;
import quack.MuteQuack;

//가짜 오리
public class DecoyDuck extends Duck{

    public DecoyDuck(){
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }

    @Override
    public void display() {
        System.out.println("가짜오리");
    }
}
