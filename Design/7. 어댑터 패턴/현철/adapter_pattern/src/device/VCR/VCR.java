package device.VCR;

import device.Controller;
import device.Output;

public class VCR {
    Output output;
    Controller remote;
    boolean powerSwitch;

    public VCR() {
        this.output = Output.RCA;
        this.remote = Controller.REMOTE;
        this.powerSwitch = false;
    }

    public void getOutput() {
        System.out.println("VCR의 출력형식은 " + this.output + "입니다.");
    }

    public void getController() {
        System.out.println("VCR의 컨트롤러는 " + this.remote + "입니다.");
    }
    public void setPowerSwitch(boolean powerSwitch) {
        this.powerSwitch = powerSwitch;
    }
    public boolean isPowerSwitch() {
        return powerSwitch;
    }
}
