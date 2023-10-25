package src.car.segment;

import src.car.Car;

public class SegmentC implements Car {

    @Override
    public String describe() {
        return "Segment: C";
    }

    @Override
    public long cost() {
        return 30_000;
    }

}
