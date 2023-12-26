package commandPattern.IoTDevice;

public abstract class Device {
    boolean power;

    Integer temperature;

    public boolean getPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
        System.out.println("power : " + (power?"ON":"OFF"));
    }

    public Integer getTemperatue() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
        System.out.println("temperature : " + temperature);

    }
}