package controller.command.monitor;

import controller.command.Command;
import device.Monitor;

public class Power extends AbstractMonitorCommand implements Command {
    public Power(Monitor monitor) {
        super(monitor);
    }

    @Override
    public void execute() {
        monitor.changePower();
    }
}
