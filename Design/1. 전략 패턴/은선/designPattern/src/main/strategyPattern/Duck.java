package main.strategyPattern;

import main.strategyPattern.flybehavior.FlyBehavior;
import main.strategyPattern.quackbehavior.QuackBehavior;
import main.strategyPattern.eatbehavior.EatingBehavior;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    EatingBehavior eatBehavior;

    public Duck() {}

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performEat() {
        eatBehavior.eat();
    }

    public void swim() {
        System.out.println("모든 오리는 물에 뜹니다. 가짜 오리도 뜨죠.");
    }
}
