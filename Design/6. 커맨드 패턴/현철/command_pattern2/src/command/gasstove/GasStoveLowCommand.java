package command.gasstove;

import command.Command;

public class GasStoveLowCommand implements Command {
    GasStove gasStove;
    GasStoveLevel previousLevel;

    public GasStoveLowCommand(GasStove gasStove) {
        this.gasStove = gasStove;
    }

    @Override
    public void execute() {
        previousLevel = gasStove.getLevel();
        gasStove.setLevel(GasStoveLevel.LOW);
    }

    @Override
    public void undo() {
        gasStove.setLevel(previousLevel);
    }
}
