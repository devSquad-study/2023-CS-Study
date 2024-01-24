package command.car;

import command.airconditioner.UnableToLowerTemperatureException;

public class Car {
    private CarState state;
    private int carAirConditionerTemperature;
    private final int MAX_TEMPERATURE = 26;


    public Car(CarState state) {
        if (state == CarState.ON) {
            this.carAirConditionerTemperature = 28;
        }
        setState(state);
    }

    public void increaseTemperature() {
        if (state == CarState.OFF) {
            System.out.println("[ERROR] 자동차의 시동이 걸려있지 않습니다.");
        }
        carAirConditionerTemperature++;
    }

    public void decreaseTemperature() throws UnableToLowerTemperatureException {
        if (state == CarState.OFF) {
            System.out.println("[ERROR] 자동차의 시동이 걸려있지 않습니다.");
        } else if (carAirConditionerTemperature <= MAX_TEMPERATURE) {
            System.out.println("[ERROR] 26도 이하로 온도를 내릴 수 없습니다.");
        }
        carAirConditionerTemperature--;
    }

    public void setTemperature(int temperature) {
        if (state == CarState.OFF) {
            System.out.println("[ERROR] 자동차의 시동이 걸려있지 않습니다.");
        }
        this.carAirConditionerTemperature = temperature;
    }

    public int getTemperature() {
        return carAirConditionerTemperature;
    }

    public void setState(CarState state) {
        this.state = state;
    }

    public CarState getState() {
        return state;
    }
}
