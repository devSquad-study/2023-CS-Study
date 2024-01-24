package Machine.command.airconditioner;

import Machine.command.Command;

public class AirConditionerDownTemperature implements Command {
    int temperature;
    int prevTemperature;

    public AirConditionerDownTemperature(int temperature) {
        this.temperature = temperature;
    }


    @Override
    public void execute() {
        prevTemperature = temperature;
        temperature--;
    }

    @Override
    public void undo() {
        temperature = prevTemperature;
    }
}
