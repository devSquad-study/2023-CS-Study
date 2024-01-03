package controller;

import controller.command.Command;
import controller.command.desk.HeightDown;
import controller.command.desk.HeightUp;
import controller.command.monitor.BlueLight;
import controller.command.monitor.BrightnessDown;
import controller.command.monitor.BrightnessUp;
import controller.command.monitor.ColorBlinded;
import controller.command.monitor.HDR;
import controller.command.monitor.Power;
import device.Monitor;
import device.MotionDesk;

import java.util.ArrayList;
import java.util.List;

public class SimpleRemoteController implements RemoteController {

    private final List<Command> commands;

    public SimpleRemoteController() {
        commands = new ArrayList<>();

        Monitor monitor = new Monitor();
        commands.add(new Power(monitor));
        commands.add(new HDR(monitor));
        commands.add(new BlueLight(monitor));
        commands.add(new ColorBlinded(monitor));
        commands.add(new BrightnessUp(monitor));
        commands.add(new BrightnessDown(monitor));

        MotionDesk motionDesk = new MotionDesk();
        commands.add(new HeightUp(motionDesk));
        commands.add(new HeightDown(motionDesk));
    }

    //@Override
    //public void addButton(Command command) {
    //    commands.add(command);
    //}

    @Override
    public void button(int slot) {
        commands.get(slot).execute();
    }

}
