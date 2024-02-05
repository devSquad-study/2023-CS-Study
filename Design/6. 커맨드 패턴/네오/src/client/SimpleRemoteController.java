package client;

import command.IotCommand;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Optional;

public class SimpleRemoteController implements RemoteController {

    private final static int SLOT_AMOUNT = 3;
    private final IotCommand[] button01;
    private final IotCommand[] button02;
    private final IotCommand[] button03;
    private final Deque<IotCommand> history;

    public SimpleRemoteController() {
        this.button01 = new IotCommand[SLOT_AMOUNT];
        this.button02 = new IotCommand[SLOT_AMOUNT];
        this.button03 = new IotCommand[SLOT_AMOUNT];
        this.history = new LinkedList<>();
    }

    @Override
    public void setButton01(int slot, IotCommand command) {
        assert command != null;
        this.button01[slot] = command;
    }

    @Override
    public void setButton02(int slot, IotCommand command) {
        assert command != null;
        this.button02[slot] = command;
    }

    @Override
    public void setButton03(int slot, IotCommand command) {
        assert command != null;
        this.button03[slot] = command;
    }

    @Override
    public void button01(int slot) {
        execute(slot, button01);
    }

    @Override
    public void button02(int slot) {
        execute(slot, button02);
    }

    @Override
    public void button03(int slot) {
        execute(slot, button03);
    }

    private void execute(int slot, IotCommand[] button) {
        Optional.ofNullable(button[slot]).ifPresent(command -> {
            command.execute();
            history.add(command);
            if (history.size() > 5) {
                history.removeFirst();
            }
        });
    }

    @Override
    public void undo() {
        Optional.ofNullable(history.pollLast()).ifPresentOrElse(IotCommand::undo, () -> {
            throw new NoSuchElementException();
        });
    }
}
