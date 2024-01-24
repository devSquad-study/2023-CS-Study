package Machine.machine;

public class GasStove implements Machine {
    static final int HIGH = 3;
    static final int MEDIUM = 2;
    static final int LOW = 1;
    static final int OFF = 0;

    int tempStatus;
    private volatile static GasStove gasStove;
    private GasStove() {
    }

    public static GasStove getGasStove() {
        if (gasStove == null) {
            synchronized (GasStove.class) {
                if (gasStove == null) {
                    gasStove = new GasStove();
                }
            }
        }

        return gasStove;
    }

    public void setHigh() {
        tempStatus = HIGH;
    }

    public void setMedium() {
        tempStatus = MEDIUM;
    }

    public void setLow() {
        tempStatus = LOW;
    }

    public void setOff() {
        tempStatus = OFF;
    }

    public int getTempStatus() {
        return tempStatus;
    }

    @Override
    public void pushButton(int command) {

    }
}
