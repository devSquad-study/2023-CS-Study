package Machine.command;

public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("[ERROR] 등록되지 않은 버튼입니다.");
    }

    @Override
    public void undo() {

    }
}
