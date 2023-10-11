package main.strategyPattern.eatbehavior;

public class CanEat implements EatingBehavior {
    @Override
    public void eat() {
        System.out.println("먹을 수 있어요.");
    }
}
