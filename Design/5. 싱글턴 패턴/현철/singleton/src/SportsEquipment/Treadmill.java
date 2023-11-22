package SportsEquipment;

public class Treadmill implements Equipment {
    private volatile static Treadmill treadmill;

    private Treadmill() {
    }

    public static Treadmill getTreadmill() {
        if (treadmill == null) {
            synchronized (Treadmill.class) {
                if (treadmill == null) {
                    treadmill = new Treadmill();
                }
            }
        }

        return treadmill;
    }

    @Override
    public void sleep(int time) throws InterruptedException {
        System.out.printf("%s %s%n", Thread.currentThread().getName(), this.getClass().getSimpleName());
        Thread.sleep(time);
    }

    @Override
    public void message() {

    }
}
