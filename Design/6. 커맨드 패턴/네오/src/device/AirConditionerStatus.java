package device;

public class AirConditionerStatus {

    private static final AirConditionerStatus INSTANCE = new AirConditionerStatus();
    private boolean isPowerOn;
    private int temperature;

    public AirConditionerStatus() {
        this.isPowerOn = false;
        this.temperature = 28;
    }

    public static AirConditionerStatus getInstance() {
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
