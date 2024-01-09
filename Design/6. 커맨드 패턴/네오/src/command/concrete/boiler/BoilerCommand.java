package command.concrete.boiler;

import command.IotCommand;
import command.concrete.gasrange.GasStoveCommand;
import device.BoilerStatus;

public abstract class BoilerCommand extends IotCommand {

    protected final BoilerStatus status;

    public BoilerCommand() {
        this.status = BoilerStatus.getInstance();
    }

    public static class Power extends BoilerCommand {
        @Override
        public void execute() {
            status.changePowerStatus();
            System.out.printf("보일러 전원: %s%n", status.isPowerOn());
        }

        @Override
        public void undo() {
            status.changePowerStatus();
            System.out.printf("보일러 전원: %s%n", status.isPowerOn());
        }
    }

    public static class Up extends BoilerCommand {
        @Override
        public void execute() {
            assert status.isPowerOn();
            status.up();
            System.out.printf("보일러 온도를 높입니다. status: %s%n", status.getTemperature());
        }

        @Override
        public void undo() {
            assert status.isPowerOn();
            status.down();
            System.out.printf("보일러 온도를 납춥니다. status: %s%n", status.getTemperature());
        }
    }

    public static class Down extends BoilerCommand {
        @Override
        public void execute() {
            assert status.isPowerOn();
            status.down();
            System.out.printf("보일러 온도를 납춥니다. status: %s%n", status.getTemperature());
        }

        @Override
        public void undo() {
            assert status.isPowerOn();
            status.up();
            System.out.printf("보일러 온도를 높입니다. status: %s%n", status.getTemperature());
        }
    }

}
