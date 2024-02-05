package command.airconditioner;

public class IncreaseAirConditionerTemperatureCommand extends AirConditionerTemperatureChangeCommand {

    public IncreaseAirConditionerTemperatureCommand(AirConditioner airConditioner) {
        super(airConditioner);
    }

    @Override
    protected void changeTemperature() {
        airConditioner.increaseTemperature();
    }
}
