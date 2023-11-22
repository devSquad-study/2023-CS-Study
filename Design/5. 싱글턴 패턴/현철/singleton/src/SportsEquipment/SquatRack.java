package SportsEquipment;

public class SquatRack implements Equipment {
    private volatile static SquatRack squatRack;

    private SquatRack() {
    }

    public static SquatRack getSquatRack() {
        if (squatRack == null) {
            synchronized (SquatRack.class) {
                if (squatRack == null) {
                    squatRack = new SquatRack();
                }
            }
        }

        return squatRack;
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
