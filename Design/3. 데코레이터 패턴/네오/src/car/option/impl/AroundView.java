package src.car.option.impl;

import src.car.Car;
import src.car.option.CarOption;

public class AroundView extends CarOption {

    public AroundView(Car car) {
        super(car);
    }

    @Override
    public long cost() {
        return super.car.cost() + 500;
    }

    @Override
    public String describe() {
        return super.car.describe() + "\nOption: " + this.getClass().getSimpleName();
    }

}
