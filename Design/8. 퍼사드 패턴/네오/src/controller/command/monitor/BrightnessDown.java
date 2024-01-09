package controller.command.monitor;

import controller.command.Command;
import device.Monitor;

public class BrightnessDown extends AbstractMonitorCommand implements Command {
    public BrightnessDown(Monitor monitor) {
        super(monitor);
    }

    @Override
    public void execute() {
        monitor.changeBrightness(-50);
    }
}
