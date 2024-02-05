package device.CD;

import device.Controller;
import device.Output;

public class CD {
    Output output;
    Controller remote;
    Controller button;
    boolean powerSwitch;

    public CD() {
        this.output = Output.AUDIO;
        this.remote = Controller.REMOTE;
        this.button = Controller.BUTTON;
        this.powerSwitch = false;
    }

    public void getOutput() {
        System.out.println("CD의 출력형식은 " + this.output + "입니다.");
    }

    public void getController() {
        System.out.println("CD의 컨트롤러는 " + this.remote + ", " + this.button + "입니다.");
    }

    public void setPowerSwitch(boolean powerSwitch) {
        this.powerSwitch = powerSwitch;
    }

    public boolean isPowerSwitch() {
        return powerSwitch;
    }
}
