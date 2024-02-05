package Machine.command.gasstove;

import Machine.machine.GasStove;
import Machine.command.Command;

public class GasStoveLowCommand implements Command {
    GasStove gasStove;
    int prevStatus;
    GasStoveUndo gasStoveUndo = new GasStoveUndo();

    public GasStoveLowCommand(GasStove gasStove) {
        this.gasStove = gasStove;
    }

    @Override
    public void execute() {
        prevStatus = gasStove.getTempStatus();
        gasStove.setLow();System.out.println("[INFO] 가스레인지가 \"하\" 로 조절 되었습니다.");
    }

    @Override
    public void undo() {

        gasStoveUndo.undo(prevStatus);
    }
}
