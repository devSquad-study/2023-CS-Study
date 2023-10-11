package duck;

import fly.FlyBehavior;
import fly.FlyWithWings;
import quack.Quack;
import quack.QuackBehavior;

//오리
public class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public Duck(){
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    public void swim(){
        System.out.println("첨벙첨벙");
    }

    public void display(){
        System.out.println("오리");
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void performFly(){
        flyBehavior.fly();
    }

    void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }

    void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior = quackBehavior;
    }
}
