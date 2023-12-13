package command.airconditioner;

import command.Command;
import java.util.Stack;

public abstract class AirConditionerTemperatureChangeCommand implements Command {
    private static final String UNDO_ERROR_MSG = "[ERROR] 더 이상 뒤로 가기 할 수 없습니다.";

    protected final AirConditioner airConditioner;
    protected final Stack<Integer> previousTemperatures = new Stack<>();

    public AirConditionerTemperatureChangeCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() throws UnableToLowerTemperatureException {
        previousTemperatures.push(airConditioner.getTemperature());
        changeTemperature();
    }

    @Override
    public void undo() {
        if (previousTemperatures.isEmpty()) {
            System.out.println(UNDO_ERROR_MSG);
        }

        airConditioner.setTemperature(previousTemperatures.pop());
    }

    protected abstract void changeTemperature() throws UnableToLowerTemperatureException;
}
