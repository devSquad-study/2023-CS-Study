import client.RemoteController;
import client.SimpleRemoteController;
import command.concrete.airconditioner.AirConditionerCommand;
import command.concrete.boiler.BoilerCommand;
import command.concrete.gasrange.GasStoveCommand;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        RemoteController remoteController = new SimpleRemoteController();
        remoteController.setButton01(0, new GasStoveCommand.Up());
        remoteController.setButton02(0, new GasStoveCommand.Power());
        remoteController.setButton03(0, new GasStoveCommand.Down());
        remoteController.setButton01(1, new AirConditionerCommand.Up());
        remoteController.setButton02(1, new AirConditionerCommand.Power());
        remoteController.setButton03(1, new AirConditionerCommand.Down());
        remoteController.setButton01(2, new BoilerCommand.Up());
        remoteController.setButton02(2, new BoilerCommand.Power());
        remoteController.setButton03(2, new BoilerCommand.Down());

        // -------------------------------------------

        remoteController.button02(0);
        remoteController.button01(0);
        remoteController.button03(0);
        remoteController.button02(1);
        remoteController.button01(1);
        remoteController.button03(1);
        remoteController.button02(2);
        remoteController.button01(2);
        remoteController.button03(2);
    }
}