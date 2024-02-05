package commandPattern.IoTDevice;

public class Car extends Device {

    public AirConditioner airConditioner;
    public Heater heater;

    public Car() {
        this.airConditioner = new AirConditioner();
        this.heater = new Heater();
    }
}
