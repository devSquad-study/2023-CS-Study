public class TurnOnCommand  implements Command {
    private final Device device;

    TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}
