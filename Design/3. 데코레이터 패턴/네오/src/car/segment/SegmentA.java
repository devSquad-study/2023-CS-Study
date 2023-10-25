package src.car.segment;

import src.car.Car;

public class SegmentA implements Car {

    @Override
    public String describe() {
        return "Segment: A";
    }

    @Override
    public long cost() {
        return 10_000;
    }

}
