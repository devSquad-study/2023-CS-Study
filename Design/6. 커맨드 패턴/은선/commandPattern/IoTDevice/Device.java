package commandPattern.IoTDevice;

public interface Device {
    void turnOn();
    void turnOff();
    void setTemperature(int temperature);
}