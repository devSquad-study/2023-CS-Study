package device;

public class BoilerStatus extends DeviceStatus {

    private static final BoilerStatus INSTANCE = new BoilerStatus();
    private boolean isPowerOn;
    private int temperature;

    public BoilerStatus() {
        this.isPowerOn = false;
        this.temperature = 60;
    }

    public static BoilerStatus getInstance() {
        return INSTANCE;
    }

    public boolean isPowerOn() {
        return isPowerOn;
    }

    public int getTemperature() {
        return temperature;
    }

    public void changePowerStatus() {
        this.isPowerOn = !this.isPowerOn;
    }

    public void up() {
        this.temperature++;
    }

    public void down() {
        this.temperature--;
    }

}
