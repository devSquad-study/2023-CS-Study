package Machine.command.gasstove;

import Machine.command.Command;
import Machine.machine.GasStove;
import Machine.machine.Machine;

public class GasStoveCommand implements Machine {
    static final int INIT_GAS_STOVE = 0;
    static Command[] commands = new Command[4];


    GasStoveOffCommand gasStoveOffCommand = new GasStoveOffCommand(GasStove.getGasStove());
    GasStoveHighCommand gasStoveHighCommand = new GasStoveHighCommand(GasStove.getGasStove());
    GasStoveMediumCommand gasStoveMediumCommand = new GasStoveMediumCommand(GasStove.getGasStove());
    GasStoveLowCommand gasStoveLowCommand = new GasStoveLowCommand(GasStove.getGasStove());


    public GasStoveCommand() {
        commands[0] = gasStoveOffCommand;
        commands[1] = gasStoveHighCommand;
        commands[2] = gasStoveMediumCommand;
        commands[3] = gasStoveLowCommand;
    }

    @Override
    public void pushButton(int command) {
        gasStoveHighCommand.execute();
    }
}
