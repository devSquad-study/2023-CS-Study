package device.VHS;

import device.NotEnoughEnergy;
import device.Player;

public class VHSAdapter implements Player {
    VHS vhs;

    public VHSAdapter(VHS vhs) {
        this.vhs = vhs;
    }

    @Override
    public void controller() {
        vhs.getController();
    }

    @Override
    public void output() {
        if (vhs.isPowerSwitch()) {
            vhs.getOutput();

            return;
        }

        System.out.println("전원이 꺼져있습니다.");
    }

    @Override
    public int remoteController(int onDevice) {
        if (onDevice == 2) {
            throw new NotEnoughEnergy();
        }
        if (vhs.isPowerSwitch()) {
            vhs.setPowerSwitch(false);

            return onDevice - 1;
        }

        vhs.setPowerSwitch(true);

        return onDevice + 1;
    }

    @Override
    public void powerSwitch() {
        if (vhs.isPowerSwitch()) {
            System.out.println("전원이 켜졌습니다.");
        } else {
            System.out.println("전원이 꺼졌습니다.");
        }
    }
}
