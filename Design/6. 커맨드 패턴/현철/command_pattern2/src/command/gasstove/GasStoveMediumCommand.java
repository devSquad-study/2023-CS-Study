package command.gasstove;

import command.Command;

public class GasStoveMediumCommand implements Command {
    GasStove gasStove;
    GasStoveLevel previousLevel;

    public GasStoveMediumCommand(GasStove gasStove) {
        this.gasStove = gasStove;
    }

    @Override
    public void execute() {
        previousLevel = gasStove.getLevel();
        gasStove.setLevel(GasStoveLevel.MEDIUM);
    }

    @Override
    public void undo() {
        gasStove.setLevel(previousLevel);
    }
}
