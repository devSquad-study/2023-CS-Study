package adapterPattern.device;

import adapterPattern.device.control.RemoteControl;

public class VhsPlayer extends Device{

    public VhsPlayer(String control){
        if (control.equals("리모컨")){
            controlProtocol = new RemoteControl();
        } else {
            System.out.println("영상 장치가 감지되지 않았습니다.");
        }
    }

    @Override
    public void outputSignal() {
        System.out.println("RCA 커넥터를 통한 아날로그 신호 출력");
    }

}

