package org.example;

import org.example.duck.Duck;
import org.example.duck.MallardDuck;
import org.example.duck.PekinDuck;
import org.example.duck.RubberDuck;

public class Main {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        System.out.println("\n" + duck.getClass().getSimpleName());
        duck.fly();
        duck.quack();

        duck = new RubberDuck();
        System.out.println("\n" + duck.getClass().getSimpleName());
        duck.fly();
        duck.quack();

        duck = new PekinDuck();
        System.out.println("\n" + duck.getClass().getSimpleName());
        duck.fly();
        duck.quack();
    }
}