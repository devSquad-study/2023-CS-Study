package commandPattern.IoTDevice;

import commandPattern.IoTDevice.Device;

public class GasStove implements Device {
    private boolean powerOn;

    public void turnOn() {
        powerOn = true;
    }

    public void turnOff() {
        powerOn = false;
    }

    public void setTemperature(int temperature) {
        // 가스레인지 온도 설정
    }
}
