package commandPattern.command;

import commandPattern.IoTDevice.Device;

public class PowerOn implements Command {
    Device device;

    public PowerOn(Device device) {
        this.device = device;
    }
    @Override
    public void execute() {
        device.setPower(true);
    }

    @Override
    public void execute(Integer temperature) {

    }
}
