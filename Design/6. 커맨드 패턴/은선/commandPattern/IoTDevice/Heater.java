package commandPattern.IoTDevice;

import commandPattern.IoTDevice.Device;

public class Heater implements Device {
    private boolean powerOn;
    private int temperature;

    public void turnOn() {
        powerOn = true;
    }

    public void turnOff() {
        powerOn = false;
    }

    public void setTemperature(int temperature) {
        if (temperature < 23) {
            this.temperature = temperature;
        } else {
            System.out.println("[ERROR] 온도가 너무 높습니다.");
        }
    }
}
