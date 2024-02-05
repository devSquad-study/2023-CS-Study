package domain;

import strategies.fly.FlyBehavior;
import strategies.quack.QuackBehavior;

public abstract class Duck {
    public FlyBehavior flyBehavior;
    public QuackBehavior quackBehavior;

    public Duck() { }

    public abstract Duck display();  // 수정: display 메서드가 Duck 인스턴스를 반환하도록 변경

    public Duck performQuack() {
        quackBehavior.quack();
        return this;  // 수정: performQuack 메서드가 Duck 인스턴스를 반환하도록 변경
    }

    public Duck performFly() {
        flyBehavior.fly();
        return this;  // 수정: performFly 메서드가 Duck 인스턴스를 반환하도록 변경
    }

    public Duck swim() {
        System.out.println("모든 오리는 물에 뜹니다. 가짜 오리도 뜨죠");
        return this;  // 수정: swim 메서드가 Duck 인스턴스를 반환하도록 변경
    }

    public Duck setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
        return this;
    }

    public Duck setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
        return this;
    }
}