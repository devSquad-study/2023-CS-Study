package Machine.command.gasstove;

import Machine.machine.GasStove;
import Machine.command.Command;

public class GasStoveMediumCommand implements Command {

    GasStove gasStove;
    int prevStatus;
    GasStoveUndo gasStoveUndo = new GasStoveUndo();

    public GasStoveMediumCommand(GasStove gasStove) {
        this.gasStove = gasStove;
    }

    @Override
    public void execute() {
        prevStatus = gasStove.getTempStatus();
        gasStove.setMedium();
        System.out.println("[INFO] 가스레인지가 \"중\" 으로 조절 되었습니다.");
    }

    @Override
    public void undo() {

        gasStoveUndo.undo(prevStatus);
    }
}
