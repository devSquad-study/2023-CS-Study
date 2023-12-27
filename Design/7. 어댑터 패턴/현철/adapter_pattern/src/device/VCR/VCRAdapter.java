package device.VCR;

import device.NotEnoughEnergy;
import device.Player;

public class VCRAdapter implements Player {
    VCR vcr;

    public VCRAdapter(VCR vcr) {
        this.vcr = vcr;
    }

    @Override
    public void controller() {
        vcr.getController();
    }

    @Override
    public void output() {
        if (vcr.isPowerSwitch()) {
            vcr.getOutput();

            return;
        }

        System.out.println("전원이 꺼져있습니다.");
    }

    @Override
    public int remoteController(int onDevice) {
        if (onDevice == 2) {
            throw new NotEnoughEnergy();
        }
        if (vcr.isPowerSwitch()) {
            vcr.setPowerSwitch(false);

            return onDevice - 1;
        }

        vcr.setPowerSwitch(true);

        return onDevice + 1;
    }

    @Override
    public void powerSwitch() {
        if (vcr.isPowerSwitch()) {
            System.out.println("전원이 켜졌습니다.");
        } else {
            System.out.println("전원이 꺼졌습니다.");
        }
    }
}
