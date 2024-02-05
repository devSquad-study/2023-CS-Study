package SportsEquipment;

public class BenchPress implements Equipment {
    private volatile static BenchPress benchPress;

    private BenchPress() {
    }

    public static BenchPress getBenchPress() {
        if (benchPress == null) {
            synchronized (BenchPress.class) {
                if (benchPress == null) {
                    benchPress = new BenchPress();
                }
            }
        }

        return benchPress;
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
