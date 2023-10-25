package src.car.option.impl;

import src.car.Car;
import src.car.option.CarOption;

public class Navigation extends CarOption {

    public Navigation(Car car) {
        super(car);
    }

    @Override
    public long cost() {
        return super.car.cost() + 1_000;
    }

    @Override
    public String describe() {
        return super.car.describe() + "\nOption: " + this.getClass().getSimpleName();
    }

}
