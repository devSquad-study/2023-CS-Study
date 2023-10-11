package main.strategyPattern.quackbehavior;

public class Sqeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("삑~~삑~~");
    }
}
