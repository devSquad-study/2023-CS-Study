package commandPattern.command;

public interface Command {
    void execute();

    void execute(Integer temperature);
}
