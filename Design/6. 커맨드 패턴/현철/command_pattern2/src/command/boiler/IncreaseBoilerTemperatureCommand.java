package command.boiler;

import command.Command;
import java.util.Stack;

public class IncreaseBoilerTemperatureCommand extends BoilerTemperatureChangeCommand {

    public IncreaseBoilerTemperatureCommand(Boiler boiler) {
        super(boiler);
    }

    @Override
    protected void changeTemperature() {
        boiler.increaseTemperature();
    }
}
