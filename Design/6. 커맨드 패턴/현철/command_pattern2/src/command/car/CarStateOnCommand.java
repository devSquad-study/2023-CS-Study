package command.car;

import command.Command;
import command.airconditioner.UnableToLowerTemperatureException;

public class CarStateOnCommand implements Command {
    Car car;
    CarState previousCarState;

    public CarStateOnCommand(Car car) {
        this.car = car;
    }

    @Override
    public void execute() throws UnableToLowerTemperatureException {
        previousCarState = car.getState();
        car.setState(CarState.ON);
    }

    @Override
    public void undo() {
        car.setState(previousCarState);
    }
}
