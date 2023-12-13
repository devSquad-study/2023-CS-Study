package device;

public class GasStoveStatus extends DeviceStatus {

    private static final GasStoveStatus INSTANCE = new GasStoveStatus();
    private boolean isPowerOn;
    private FireStatus fireStatus;

    private GasStoveStatus() {
        this.isPowerOn = false;
        this.fireStatus = FireStatus.NONE;
    }

    public static GasStoveStatus getInstance() {
        return INSTANCE;
    }

    public boolean isPowerOn() {
        return isPowerOn;
    }

    public FireStatus getFireStatus() {
        return fireStatus;
    }

    public void up() {
        switch (fireStatus) {
            case NONE -> setFireStatus(FireStatus.SMALL);
            case SMALL -> setFireStatus(FireStatus.MID);
            case MID -> setFireStatus(FireStatus.LARGE);
            default -> throw new IllegalStateException();
        }
    }

    public void down() {
        switch (fireStatus) {
            case LARGE -> setFireStatus(FireStatus.MID);
            case MID -> setFireStatus(FireStatus.SMALL);
            case SMALL -> setFireStatus(FireStatus.NONE);
            default -> throw new IllegalStateException();
        }
    }

    public void changePowerStatus() {
        this.isPowerOn = !this.isPowerOn;
    }

    public void setFireStatus(FireStatus fireStatus) {
        this.fireStatus = fireStatus;
    }

    public enum FireStatus {
        NONE, SMALL, MID, LARGE
    }

}
