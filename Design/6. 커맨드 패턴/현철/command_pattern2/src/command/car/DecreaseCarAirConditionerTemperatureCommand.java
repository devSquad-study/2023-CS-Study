package command.car;

import command.airconditioner.UnableToLowerTemperatureException;

public class DecreaseCarAirConditionerTemperatureCommand extends CarAirConditionerTemperatureChangeCommand {
    public DecreaseCarAirConditionerTemperatureCommand(Car car) {
        super(car);
    }

    @Override
    protected void changeTemperature() throws UnableToLowerTemperatureException {
        car.decreaseTemperature();
    }
}
