package commandPattern.command;

import commandPattern.IoTDevice.GasStove;
import commandPattern.command.Command;

public class GasStoveCommand implements Command {
    private GasStove gasStove;
    private String action;

    public GasStoveCommand(GasStove gasStove, String action) {
        this.gasStove = gasStove;
        this.action = action;
    }

    public void execute() {
        if (action.equals("on")) {
            gasStove.turnOn();
            System.out.println("가스레인지가 켜졌습니다.");
        } else if (action.equals("off")) {
            gasStove.turnOff();
            System.out.println("가스레인지가 꺼졌습니다.");
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
}
