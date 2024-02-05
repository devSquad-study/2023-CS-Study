package commandPattern.command;

import commandPattern.IoTDevice.Device;

public class SetTemperature implements Command {
    Device device;

    public SetTemperature(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        System.out.println("온도가 입력되지 않음");
    }

    @Override
    public void execute(Integer temperature) {
        device.setTemperature(temperature);
    }
}
