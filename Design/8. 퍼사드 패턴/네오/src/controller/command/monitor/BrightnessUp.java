package controller.command.monitor;

import controller.command.Command;
import device.Monitor;

public class BrightnessUp extends AbstractMonitorCommand implements Command {
    public BrightnessUp(Monitor monitor) {
        super(monitor);
    }

    @Override
    public void execute() {
        monitor.changeBrightness(50);
    }
}
