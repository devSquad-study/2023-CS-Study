package command.concrete.gasrange;

import command.IotCommand;
import device.GasStoveStatus;

public abstract class GasStoveCommand extends IotCommand {

    protected final GasStoveStatus status;

    protected GasStoveCommand() {
        status = GasStoveStatus.getInstance();
    }

    public static class Power extends GasStoveCommand {
        @Override
        public void execute() {
            status.changePowerStatus();
            System.out.printf("가스레인지 전원: %s%n", status.isPowerOn());
        }

        @Override
        public void undo() {
            status.changePowerStatus();
            System.out.printf("가스레인지 전원: %s%n", status.isPowerOn());
        }
    }

    public static class Up extends GasStoveCommand {
        @Override
        public void execute() {
            assert status.isPowerOn();
            status.up();
            System.out.printf("가스레인지 출력을 높입니다. status: %s%n", status.getFireStatus());
        }

        @Override
        public void undo() {
            assert status.isPowerOn();
            status.down();
            System.out.printf("가스레인지 출력을 납춥니다. status: %s%n", status.getFireStatus());
        }
    }

    public static class Down extends GasStoveCommand {
        @Override
        public void execute() {
            assert status.isPowerOn();
            status.down();
            System.out.printf("가스레인지 출력을 납춥니다. status: %s%n", status.getFireStatus());
        }

        @Override
        public void undo() {
            assert status.isPowerOn();
            status.up();
            System.out.printf("가스레인지 출력을 높입니다. status: %s%n", status.getFireStatus());
        }
    }

}
