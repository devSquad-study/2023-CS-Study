package commandPattern.command;

import commandPattern.IoTDevice.AirConditioner;

public class AirConditionerCommand implements Command {

    private AirConditioner airConditioner;
    private String action;
    private int temperature;

    public AirConditionerCommand(AirConditioner airConditioner, String action) {
        this.airConditioner = airConditioner;
        this.action = action;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void execute() {
        if (action.equals("on")) {
            airConditioner.turnOn();
            System.out.println("에어컨이 켜졌습니다.");
            if (temperature > 0) {
                airConditioner.setTemperature(temperature);
                System.out.println("온도를 " + temperature + "도로 설정했습니다.");
            }
        } else if (action.equals("off")) {
            airConditioner.turnOff();
            System.out.println("에어컨이 꺼졌습니다.");
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
}
