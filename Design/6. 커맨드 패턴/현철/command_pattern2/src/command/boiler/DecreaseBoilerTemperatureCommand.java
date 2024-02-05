package command.boiler;

public class DecreaseBoilerTemperatureCommand extends BoilerTemperatureChangeCommand {

    public DecreaseBoilerTemperatureCommand(Boiler boiler) {
        super(boiler);
    }

    @Override
    protected void changeTemperature() {
        boiler.decreaseTemperature();
    }
}
