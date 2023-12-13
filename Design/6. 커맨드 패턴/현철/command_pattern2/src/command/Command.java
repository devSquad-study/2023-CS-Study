package command;

import command.airconditioner.UnableToLowerTemperatureException;

public interface Command {
    void execute() throws UnableToLowerTemperatureException;
    void undo();
}
