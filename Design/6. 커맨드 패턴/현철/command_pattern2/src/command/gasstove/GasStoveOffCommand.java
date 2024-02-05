package command.gasstove;

import command.Command;

public class GasStoveOffCommand implements Command {
    GasStove gasStove;

    GasStoveLevel previousLevel;

    public GasStoveOffCommand(GasStove gasStove) {
        this.gasStove = gasStove;
    }

    @Override
    public void execute() {
        previousLevel = gasStove.getLevel();
        gasStove.setLevel(GasStoveLevel.OFF);
    }

    @Override
    public void undo() {
        gasStove.setLevel(previousLevel);
    }
}
