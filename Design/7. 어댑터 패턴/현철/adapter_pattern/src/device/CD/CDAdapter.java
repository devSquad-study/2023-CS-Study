package device.CD;

import device.NotEnoughEnergy;
import device.Player;

public class CDAdapter implements Player {
    CD cd;

    public CDAdapter(CD cd) {
        this.cd = cd;
    }

    @Override
    public void controller() {
        cd.getController();
    }

    @Override
    public void output() {
        if (cd.isPowerSwitch()) {
            cd.getOutput();

            return;
        }

        System.out.println("전원이 꺼져있습니다.");
    }

    @Override
    public int remoteController(int onDevice) {
        if (onDevice == 2) {
            throw new NotEnoughEnergy();
        }
        if (cd.isPowerSwitch()) {
            cd.setPowerSwitch(false);

            return onDevice - 1;
        }

        cd.setPowerSwitch(true);

        return onDevice + 1;
    }

    @Override
    public void powerSwitch() {
        if (cd.isPowerSwitch()) {
            System.out.println("전원이 켜졌습니다.");
        } else {
            System.out.println("전원이 꺼졌습니다.");
        }
    }
}
