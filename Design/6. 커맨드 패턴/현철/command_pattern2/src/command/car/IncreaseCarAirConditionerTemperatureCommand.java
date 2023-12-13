package command.car;

public class IncreaseCarAirConditionerTemperatureCommand extends CarAirConditionerTemperatureChangeCommand{
    public IncreaseCarAirConditionerTemperatureCommand(Car car) {
        super(car);
    }

    @Override
    protected void changeTemperature() {
        car.increaseTemperature();
    }
}
