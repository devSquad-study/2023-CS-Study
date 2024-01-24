package command.boiler;

import command.Command;
import command.airconditioner.UnableToLowerTemperatureException;
import java.util.Stack;

public abstract class BoilerTemperatureChangeCommand implements Command {
    private static final String UNDO_ERROR_MSG = "[ERROR] 더 이상 뒤로 가기 할 수 없습니다.";

    protected final Boiler boiler;
    protected final Stack<Integer> previousTemperatures = new Stack<>();

    public BoilerTemperatureChangeCommand(Boiler boiler) {
        this.boiler = boiler;
    }

    @Override
    public void execute() throws UnableToLowerTemperatureException {
        previousTemperatures.push(boiler.getTemperature());
        changeTemperature();
    }

    @Override
    public void undo() {
        if (previousTemperatures.isEmpty()) {
            System.out.println(UNDO_ERROR_MSG);
        }

        boiler.setTemperature(previousTemperatures.pop());
    }

    protected abstract void changeTemperature();
}
