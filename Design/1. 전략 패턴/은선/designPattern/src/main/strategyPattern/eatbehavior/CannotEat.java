package main.strategyPattern.eatbehavior;

public class CannotEat implements EatingBehavior {
    @Override
    public void eat() {
        System.out.println("먹을 수 없어요!!");

    }
}
