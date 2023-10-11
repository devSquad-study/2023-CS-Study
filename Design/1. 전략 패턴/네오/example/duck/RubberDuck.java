package org.example.duck;

import org.example.duck.flight.impl.NonFlightStrategy;
import org.example.duck.quack.impl.MuteQuackStrategy;

public class RubberDuck extends Duck {

    public RubberDuck() {
        super.flightStrategy = new NonFlightStrategy();
        super.quackStrategy = new MuteQuackStrategy();
    }

}
