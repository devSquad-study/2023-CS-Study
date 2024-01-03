package controller.command.monitor;

import controller.command.Command;
import device.Monitor;

public class BlueLight extends AbstractMonitorCommand implements Command {
    public BlueLight(Monitor monitor) {
        super(monitor);
    }

    @Override
    public void execute() {
        monitor.changeBlueLight();
    }
}
