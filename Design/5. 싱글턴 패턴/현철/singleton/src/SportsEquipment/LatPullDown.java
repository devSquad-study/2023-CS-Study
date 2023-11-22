package SportsEquipment;

public class LatPullDown implements Equipment {
    private volatile static LatPullDown latPullDown;

    private LatPullDown() {
    }

    public static LatPullDown getLatPullDown() {
        if (latPullDown == null) {
            synchronized (LatPullDown.class) {
                if (latPullDown == null) {
                    latPullDown = new LatPullDown();
                }
            }
        }

        return latPullDown;
    }

    @Override
    public void sleep(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    @Override
    public void message() {

    }
}
