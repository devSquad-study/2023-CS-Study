package commandPattern.command;

import commandPattern.IoTDevice.Car;

public class CarCommand implements Command {
    private Car car;
    private String action;
    private int temperature;

    public CarCommand(Car car, String action, int temperature) {
        this.car = car;
        this.action = action;
        this.temperature = temperature;
    }

    public void execute() {
        if (action.equals("on")) {
            car.turnOn();
            System.out.println("자동차 시동이 켜졌습니다.");
        } else if (action.equals("off")) {
            car.turnOff();
            System.out.println("자동차 시동이 꺼졌습니다.");
        } else {
            System.out.println("잘못된 입력입니다.");
            return;
        }

//        if (temperature == 1) {
//            setAirConditionerTemperature(temperature);
//        } else if (temperature == 2) {
//            setHeaterTemperature(temperature);
//        } else {
//            System.out.println("잘못된 옵션입니다.");
//        }
    }

    public void setAirConditionerTemperature(int temperature) {
        System.out.print("에어컨 온도를 설정하세요: ");
        car.setAirConditionerTemperature(temperature);
    }

    public void setHeaterTemperature(int temperature) {
        System.out.print("히터 온도를 설정하세요: ");
        car.setHeaterTemperature(temperature);
    }

}
