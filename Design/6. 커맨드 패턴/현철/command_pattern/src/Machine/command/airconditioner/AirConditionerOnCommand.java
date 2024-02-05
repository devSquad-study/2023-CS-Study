package Machine.command.airconditioner;

import Machine.machine.AirConditioner;
import Machine.command.Command;

public class AirConditionerOnCommand implements Command {
    AirConditioner airConditioner;

    public AirConditionerOnCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
