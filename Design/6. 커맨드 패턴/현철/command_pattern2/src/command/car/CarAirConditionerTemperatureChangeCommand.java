package command.car;

import command.Command;
import command.airconditioner.UnableToLowerTemperatureException;
import java.util.Stack;

public abstract class CarAirConditionerTemperatureChangeCommand implements Command {
    protected final Car car;
    private static final String NOT_START_ERROR_MSG = "[ERROR] 자동차의 시동이 걸려있지 않습니다.";
    private static final String UNDO_ERROR_MSG = "[ERROR] 더 이상 뒤로 가기 할 수 없습니다.";
    protected final Stack<Integer> previousTemperatures = new Stack<>();

    public CarAirConditionerTemperatureChangeCommand(Car car) {
        this.car = car;
    }

    @Override
    public void execute() throws UnableToLowerTemperatureException {
        previousTemperatures.push(car.getTemperature());
        changeTemperature();
    }

    @Override
    public void undo() {
        if (car.getState() == CarState.OFF) {
            System.out.println(NOT_START_ERROR_MSG);
        } else if (previousTemperatures.isEmpty()) {
            System.out.println(UNDO_ERROR_MSG);
        }

        car.setTemperature(previousTemperatures.pop());
    }

    protected abstract void changeTemperature() throws UnableToLowerTemperatureException;
}
