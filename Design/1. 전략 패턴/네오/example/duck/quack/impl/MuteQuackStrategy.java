package org.example.duck.quack.impl;

import org.example.duck.quack.QuackStrategy;

public class MuteQuackStrategy implements QuackStrategy {

    @Override
    public void quack() {
        System.out.println("울 수 없어요!");
    }

}
