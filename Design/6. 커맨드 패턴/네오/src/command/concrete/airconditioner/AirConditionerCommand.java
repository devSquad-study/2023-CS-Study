package command.concrete.airconditioner;

import command.IotCommand;
import device.AirConditionerStatus;

public abstract class AirConditionerCommand extends IotCommand {

    protected final AirConditionerStatus status;

    public AirConditionerCommand() {
        this.status = AirConditionerStatus.getInstance();
    }

    public static class Power extends AirConditionerCommand {
        @Override
        public void execute() {
            status.changePowerStatus();
            System.out.printf("에어컨 전원: %s%n", status.isPowerOn());
        }

        @Override
        public void undo() {
            status.changePowerStatus();
            System.out.printf("에어컨 전원: %s%n", status.isPowerOn());
        }
    }

    public static class Up extends AirConditionerCommand {
        @Override
        public void execute() {
            assert status.isPowerOn();
            status.up();
            System.out.printf("에어컨 온도를 높입니다. temp: %s%n", status.getTemperature());
        }

        @Override
        public void undo() {
            assert status.isPowerOn();
            status.down();
            System.out.printf("에어컨 온도를 납춥니다. temp: %s%n", status.getTemperature());
        }
    }

    public static class Down extends AirConditionerCommand {
        @Override
        public void execute() {
            assert status.isPowerOn();
            status.down();
            System.out.printf("에어컨 온도를 납춥니다. temp: %s%n", status.getTemperature());
        }

        @Override
        public void undo() {
            assert status.isPowerOn();
            status.up();
            System.out.printf("에어컨 온도를 높입니다. temp: %s%n", status.getTemperature());
        }
    }

}
