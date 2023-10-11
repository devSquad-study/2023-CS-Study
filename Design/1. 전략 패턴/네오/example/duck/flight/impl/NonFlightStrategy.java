package org.example.duck.flight.impl;

import org.example.duck.flight.FlightStrategy;

public class NonFlightStrategy implements FlightStrategy {

    @Override
    public void fly() {
        System.out.println("날 수 없어요!");
    }

}
