package device.VHS;

import device.Controller;
import device.Output;

public class VHS {
    Output output;
    Controller remote;
    Controller record;
    boolean powerSwitch;

    public VHS() {
        this.output = Output.RCA;
        this.remote = Controller.REMOTE;
        this.record = Controller.RECORD;
        this.powerSwitch = false;
    }

    public void getOutput() {
        System.out.println("VHS의 출력형식은 "+ this.output + "입니다.");
    }

    public void getController() {
        System.out.println("VHS의 컨트롤러는 " + this.remote + "이고 " + this.record + "가 가능합니다.");
    }

    public void setPowerSwitch(boolean powerSwitch) {
        this.powerSwitch = powerSwitch;
    }

    public boolean isPowerSwitch() {
        return powerSwitch;
    }
}
