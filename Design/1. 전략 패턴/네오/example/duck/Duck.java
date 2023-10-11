package org.example.duck;

import org.example.duck.flight.FlightStrategy;
import org.example.duck.flight.impl.DefaultFlightStrategy;
import org.example.duck.quack.QuackStrategy;
import org.example.duck.quack.impl.DefaultQuackStrategy;

public abstract class Duck {

    protected FlightStrategy flightStrategy = new DefaultFlightStrategy();
    protected QuackStrategy quackStrategy = new DefaultQuackStrategy();

    public void fly() {
        flightStrategy.fly();
    }

    public void quack() {
        quackStrategy.quack();
    }

}
