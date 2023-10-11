package org.example.duck.flight.impl;

import org.example.duck.flight.FlightStrategy;

public class DefaultFlightStrategy implements FlightStrategy {

    @Override
    public void fly() {
        System.out.println("파닥파닥");
    }

}
