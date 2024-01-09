import controller.RemoteController;
import controller.SimpleRemoteController;
import device.Computer;
import device.Monitor;
import facade.ComputerPowerOnFacade;
import facade.ComputerPowerOnFacadeImpl;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Hello world!");

        ComputerPowerOnFacade computerPowerOnFacade = new ComputerPowerOnFacadeImpl(new Computer());
        computerPowerOnFacade.start();

        //Monitor monitor = new Monitor();
        RemoteController remoteController = new SimpleRemoteController();
        //remoteController.addButton(new MonitorCommand.Power(monitor));
        //remoteController.addButton(new MonitorCommand.HDR(monitor));
        //remoteController.addButton(new MonitorCommand.BlueLight(monitor));
        //remoteController.addButton(new MonitorCommand.ColorBlinded(monitor));
        //remoteController.addButton(new MonitorCommand.BrightnessUp(monitor));
        //remoteController.addButton(new MonitorCommand.BrightnessDown(monitor));

        remoteController.button(0);

        remoteController.button(1);
        remoteController.button(1);
        remoteController.button(2);
        remoteController.button(2);
        remoteController.button(3);
        remoteController.button(3);
        remoteController.button(4);
        remoteController.button(4);
        remoteController.button(4);
        remoteController.button(5);
        remoteController.button(5);
        remoteController.button(5);
        remoteController.button(5);
        remoteController.button(5);

        remoteController.button(0);

        remoteController.button(6);
        remoteController.button(6);
        remoteController.button(6);
        remoteController.button(7);
        remoteController.button(7);
        remoteController.button(7);
        remoteController.button(7);
        remoteController.button(7);
    }

}