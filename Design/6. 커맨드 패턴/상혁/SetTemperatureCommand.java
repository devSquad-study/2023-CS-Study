public class SetTemperatureCommand implements Command {
    private final AirConditioner airConditioner;
    private final int temperature;

    SetTemperatureCommand(AirConditioner airConditioner, int temperature) {
        this.airConditioner = airConditioner;
        this.temperature = temperature;
    }

    @Override
    public void execute() {
        airConditioner.setTemperature(temperature);
    }
}
