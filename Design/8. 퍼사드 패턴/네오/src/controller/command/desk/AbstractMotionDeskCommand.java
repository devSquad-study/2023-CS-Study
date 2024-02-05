package controller.command.desk;

import device.MotionDesk;

public abstract class AbstractMotionDeskCommand {

    protected MotionDesk motionDesk;

    public AbstractMotionDeskCommand(MotionDesk motionDesk) {
        this.motionDesk = motionDesk;
    }

}
