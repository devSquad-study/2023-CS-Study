package device;

public class Monitor {

    private boolean power;
    private boolean hdr;
    private boolean blueLight;
    private boolean colorBlinded;
    private int brightness;

    public Monitor() {
        this.power = false;
        this.hdr = false;
        this.blueLight = false;
        this.colorBlinded = false;
        brightness = 300;
    }

    public void changePower() {
        power = !power;
        if (power) {
            System.out.println("모니터가 켜집니다.");
            return;
        }
        System.out.println("모니터가 꺼집니다.");
    }

    public void changeHdr() {
        if (!power) {
            return;
        }
        hdr = !hdr;
        if (hdr) {
            System.out.println("HDR 모드가 켜집니다.");
            return;
        }
        System.out.println("HDR 모드가 꺼집니다.");
    }

    public void changeBlueLight() {
        if (!power) {
            return;
        }
        blueLight = !blueLight;
        if (blueLight) {
            System.out.println("블루라이트 모드가 켜집니다.");
            return;
        }
        System.out.println("블루라이트 모드가 꺼집니다.");
    }

    public void changeColorBlinded() {
        if (!power) {
            return;
        }
        colorBlinded = !colorBlinded;
        if (colorBlinded) {
            System.out.println("색약 모드가 켜집니다.");
            return;
        }
        System.out.println("색약 모드가 꺼집니다.");
    }

    public void changeBrightness(int value) {
        if (!power) {
            return;
        }
        if (brightness + value > 400) {
            System.out.printf("[ERROR] 최대 밝기는 400nit입니다. 현재 밝기: %s\n", brightness);
            return;
        }
        if (brightness + value < 200) {
            System.out.printf("[ERROR] 최소 밝기는 200nit입니다. 현재 밝기: %s\n", brightness);
            return;
        }
        brightness += value;
        System.out.printf("현재 밝기: %s\n", brightness);
    }

}
