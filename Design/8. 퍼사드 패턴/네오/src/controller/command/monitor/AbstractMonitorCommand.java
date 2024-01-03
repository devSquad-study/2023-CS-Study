package controller.command.monitor;

import device.Monitor;

public abstract class AbstractMonitorCommand {

    protected Monitor monitor;

    public AbstractMonitorCommand(Monitor monitor) {
        this.monitor = monitor;
    }

}
