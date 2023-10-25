package src.car.option.impl;

import src.car.Car;
import src.car.option.CarOption;

public class ABS extends CarOption {

    public ABS(Car car) {
        super(car);
    }

    @Override
    public long cost() {
        return super.car.cost() + 300;
    }

    @Override
    public String describe() {
        return super.car.describe() + "\nOption: " + this.getClass().getSimpleName();
    }

}
