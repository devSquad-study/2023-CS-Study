package Machine.command.gasstove;

import Machine.machine.GasStove;
import Machine.command.Command;

public class GasStoveOffCommand implements Command {
    GasStove gasStove;
    int prevStatus;
    GasStoveUndo gasStoveUndo = new GasStoveUndo();

    public GasStoveOffCommand(GasStove gasStove) {
        this.gasStove = gasStove;
    }

    @Override
    public void execute() {
        prevStatus = gasStove.getTempStatus();
        gasStove.setOff();
        System.out.println("[INFO] 가스레인지가 꺼졌습니다.");
    }

    @Override
    public void undo() {

        gasStoveUndo.undo(prevStatus);
    }
}
