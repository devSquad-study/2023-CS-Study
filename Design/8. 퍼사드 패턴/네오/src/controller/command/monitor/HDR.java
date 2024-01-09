package controller.command.monitor;

import controller.command.Command;
import device.Monitor;

public class HDR extends AbstractMonitorCommand implements Command {
    public HDR(Monitor monitor) {
        super(monitor);
    }

    @Override
    public void execute() {
        monitor.changeHdr();
    }
}
