package command.car;

import command.Command;
import command.airconditioner.UnableToLowerTemperatureException;

public class CarStateOffCommand implements Command {
    Car car;
    CarState previousCarState;

    public CarStateOffCommand(Car car) {
        this.car = car;
    }

    @Override
    public void execute() throws UnableToLowerTemperatureException {
        previousCarState = car.getState();
        car.setState(CarState.OFF);
    }

    @Override
    public void undo() {
        car.setState(previousCarState);
    }
}
