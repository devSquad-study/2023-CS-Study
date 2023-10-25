package src.car.option;

import src.car.Car;

public abstract class CarOption implements Car {

    protected final Car car;

    public CarOption(Car car) {
        this.car = car;
    }

    public abstract String describe();

}
