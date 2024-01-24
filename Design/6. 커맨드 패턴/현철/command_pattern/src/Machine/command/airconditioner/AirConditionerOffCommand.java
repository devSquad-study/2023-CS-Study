package Machine.command.airconditioner;

import Machine.machine.AirConditioner;
import Machine.command.Command;

public class AirConditionerOffCommand implements Command {
    AirConditioner airConditioner;

    public AirConditionerOffCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
