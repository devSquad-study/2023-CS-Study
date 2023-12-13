package commandPattern.IoTDevice;

public class Car implements Device {

    private boolean powerOn;
    private int airConditionerTemperature;
    private int heaterTemperature;
    public boolean isPowerOn() {
        return this.powerOn;
    }

    public void turnOn() {
        powerOn = true;
    }

    public void turnOff() {
        powerOn = false;
    }

    @Override
    public void setTemperature(int temperature) {

    }

    public void setAirConditionerTemperature(int temperature) {
        if (powerOn) {
            if (temperature >= 26) {
                System.out.println("[ERROR] 온도가 너무 높습니다. 설정 가능 온도는 25도 이하입니다.");
                return;
            }
            this.airConditionerTemperature = temperature;
            System.out.println("에어컨 온도가 " + temperature + "도로 설정되었습니다.");
        } else {
            System.out.println("자동차 시동이 꺼져 있습니다. 먼저 시동을 켜주세요.");
        }
    }

    public void setHeaterTemperature(int temperature) {
        if (powerOn) {
            if (temperature <= 23) {
                System.out.println("[ERROR] 온도가 너무 낮습니다. 설정 가능 온도는 24도 이상입니다.");
                return;
            }
            this.heaterTemperature = temperature;
            System.out.println("히터 온도가 " + temperature + "도로 설정되었습니다.");
        } else {
            System.out.println("자동차 시동이 꺼져 있습니다. 먼저 시동을 켜주세요.");
        }
    }
}
