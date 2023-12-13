package command.airconditioner;

public class DecreaseAirConditionerTemperatureCommand extends AirConditionerTemperatureChangeCommand {

    public DecreaseAirConditionerTemperatureCommand(AirConditioner airConditioner) {
        super(airConditioner);
    }

    @Override
    protected void changeTemperature() throws UnableToLowerTemperatureException {
        airConditioner.decreaseTemperature();
    }
}
