package device;

public interface Player {
    void controller();
    void output();
    int remoteController(int onDevice);
    void powerSwitch();
}
