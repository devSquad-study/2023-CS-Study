package adapterPattern.device;

import adapterPattern.device.control.ButtonControl;
import adapterPattern.device.control.ControlProtocol;
import adapterPattern.device.control.RemoteControl;

public class CdPlayer extends Device {
    public CdPlayer(String control){
        if (control.equals("리모컨")){
            controlProtocol = new RemoteControl();
        } else if (control.equals("버튼")) {
            controlProtocol = new ButtonControl();
        }
        else {
            System.out.println("올바르지 않은 제어 방식입니다.");
        }
    }


    @Override
    public void outputSignal() {
        System.out.println("오디오 출력 (3.5mm 스테레오 잭)");
    }

}
