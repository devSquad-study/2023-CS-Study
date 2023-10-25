package src.car.segment;

import src.car.Car;

public class SegmentB implements Car {

    @Override
    public String describe() {
        return "Segment: B";
    }

    @Override
    public long cost() {
        return 20_000;
    }

}
