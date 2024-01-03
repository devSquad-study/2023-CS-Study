package controller.command.monitor;

import controller.command.Command;
import device.Monitor;

public class ColorBlinded extends AbstractMonitorCommand implements Command {
    public ColorBlinded(Monitor monitor) {
        super(monitor);
    }

    @Override
    public void execute() {
        monitor.changeColorBlinded();
    }
}
