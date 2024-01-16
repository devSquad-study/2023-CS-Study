package adapterPattern.device.control;

import adapterPattern.device.control.ControlProtocol;

public class RemoteControl implements ControlProtocol {
    @Override
    public void control() {
        System.out.println("리모컨을 통한 제어");
    }
}
