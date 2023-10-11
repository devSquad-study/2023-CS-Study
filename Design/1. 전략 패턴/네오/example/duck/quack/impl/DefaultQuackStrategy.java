package org.example.duck.quack.impl;

import org.example.duck.quack.QuackStrategy;

public class DefaultQuackStrategy implements QuackStrategy {

    @Override
    public void quack() {
        System.out.println("꽥꽥");
    }

}
