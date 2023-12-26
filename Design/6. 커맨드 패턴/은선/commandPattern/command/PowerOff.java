package commandPattern.command;

import commandPattern.IoTDevice.Device;

public class PowerOff implements Command {
    Device device;

    public PowerOff(Device device) {
        this.device = device;
    }
    @Override
    public void execute() {
        device.setPower(false);
    }

    @Override
    public void execute(Integer temperature) {

    }
}
