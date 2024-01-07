package commandPattern;

import commandPattern.command.Command;

public class Invoker {
    Command button;

    public void setCommand(Command command) {
        button = command;
    }

    public void buttonWasPressed() {
        System.out.println("button pressed..");
        button.execute();
    }

    public void buttonWasPressed(Integer temp) {
        System.out.println("button pressed..");
        button.execute(temp);
    }

}
