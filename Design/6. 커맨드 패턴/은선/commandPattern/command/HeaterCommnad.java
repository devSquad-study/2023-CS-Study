package commandPattern.command;

import commandPattern.IoTDevice.Heater;
import commandPattern.command.Command;

public class HeaterCommnad implements Command {
    private Heater heater;
    private String action;
    private int temperature;

    public HeaterCommnad(Heater heater, String action) {
        this.heater = heater;
        this.action = action;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void execute() {
        if (action.equals("on")) {
            heater.turnOn();
            System.out.println("난방이 켜졌습니다.");
            if (temperature > 0) {
                heater.setTemperature(temperature);
                System.out.println("온도를 " + temperature + "도로 설정했습니다.");
            }
        } else if (action.equals("off")) {
            heater.turnOff();
            System.out.println("난방이 꺼졌습니다.");
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
}