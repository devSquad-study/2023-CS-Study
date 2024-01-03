package controller.command.desk;

import controller.command.Command;
import device.MotionDesk;

public class HeightDown extends AbstractMotionDeskCommand implements Command {
    public HeightDown(MotionDesk motionDesk) {
        super(motionDesk);
    }

    @Override
    public void execute() {
        motionDesk.changeHeight(-10);
    }
}
