package commandPattern.IoTDevice;

public class AirConditioner implements Device {
    private boolean powerOn;
    private int temperature;

    public void turnOn() {
        powerOn = true;
    }

    public void turnOff() {
        powerOn = false;
    }

    public void setTemperature(int temperature) {
        if (temperature <= 26) {
            this.temperature = temperature;
        } else {
            System.out.println("[ERROR] 온도가 너무 높습니다.");
            // 오류 처리
        }
    }
}