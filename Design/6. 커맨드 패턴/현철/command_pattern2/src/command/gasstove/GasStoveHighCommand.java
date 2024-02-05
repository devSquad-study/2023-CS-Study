package command.gasstove;

import command.Command;

public class GasStoveHighCommand implements Command {
    GasStove gasStove;
    GasStoveLevel previousLevel;

    public GasStoveHighCommand(GasStove gasStove) {
        this.gasStove = gasStove;
    }

    @Override
    public void execute() {
        previousLevel = gasStove.getLevel();
        gasStove.setLevel(GasStoveLevel.HIGH);
    }

    @Override
    public void undo() {
        gasStove.setLevel(previousLevel);
    }
}
