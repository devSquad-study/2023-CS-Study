package adapterPattern.device.control;

public class ButtonControl implements ControlProtocol {
    @Override
    public void control() {
        System.out.println("버튼을 통한 제어");
    }
}
