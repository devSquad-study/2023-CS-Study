package Machine.machine;

import Machine.command.Command;

public class NoMachine implements Machine, Command {


    @Override
    public void execute() {
        System.out.println("[ERROR] 등록되지 않은 버튼입니다.");
    }

    @Override
    public void undo() {

    }

    @Override
    public void pushButton(int command) {

    }
}
