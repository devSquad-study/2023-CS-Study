package command.gasstove;

import command.Location;
import java.util.Timer;
import java.util.TimerTask;

public class GasStoveTimer {
    private static final long OUTDOOR_DURATION = 60 * 100;
    private final GasStove stove;
    private Timer timer;

    public GasStoveTimer(GasStove stove) {
        this.stove = stove;
    }

    public void start() {
        timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                handleGasStoveOutdoorCheck();
            }
        };
        timer.schedule(task, OUTDOOR_DURATION);
    }

    private void handleGasStoveOutdoorCheck() {
        if (stove.getLocation() == Location.OUTDOOR) {
            stove.setLevel(GasStoveLevel.OFF);
            System.out.println("[ERROR] 시간이 초과되어 가스레인지의 전원이 꺼졌습니다.");
            timer.cancel();
        }
    }

    public void stop() {
        if (timer != null) {
            timer.cancel();
        }
    }
}
