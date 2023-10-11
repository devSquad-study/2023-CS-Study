package main.strategyPattern.quackbehavior;

public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("꽥~");
    }
}
