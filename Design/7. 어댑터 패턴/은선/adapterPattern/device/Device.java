package adapterPattern.device;

import adapterPattern.device.control.ControlProtocol;

public abstract class Device implements Output{

    ControlProtocol controlProtocol;

    public void play() {
        controlProtocol.control();
        outputSignal();
        System.out.println();
    }
}
