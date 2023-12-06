package commandPattern.command;

import commandPattern.IoTDevice.Device;
import commandPattern.command.Command;

public class DeviceCommand implements Command {
    private Device device;
    private String action;

    public DeviceCommand(Device device, String action) {
        this.device = device;
        this.action = action;
    }

    public void execute() {
        switch (action) {
            case "on":
                device.turnOn();
                break;
            case "off":
                device.turnOff();
                break;
            // 다른 기능들에 대한 처리도 추가 가능
            default:
                System.out.println("잘못된 명령입니다.");
        }
    }
}
