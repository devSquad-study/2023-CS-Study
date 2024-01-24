package Machine.command.gasstove;

import Machine.machine.GasStove;
import Machine.command.Command;

public class GasStoveHighCommand implements Command {
    GasStove gasStove;
    int prevStatus;
    GasStoveUndo gasStoveUndo = new GasStoveUndo();

    public GasStoveHighCommand(GasStove gasStove) {
        this.gasStove = gasStove;
    }

    @Override
    public void execute() {
        prevStatus = gasStove.getTempStatus();
        gasStove.setHigh();
        System.out.println("[INFO] 가스레인지가 \"상\" 으로 조절 되었습니다.");
    }

    @Override
    public void undo() {

        gasStoveUndo.undo(prevStatus);
    }
}
