package SportsEquipment;

public class RowingMachine implements Equipment{
    private volatile static RowingMachine rowingMachine;

    private RowingMachine() {
    }

    public static RowingMachine getRowingMachine() {
        if (rowingMachine == null) {
            synchronized (RowingMachine.class) {
                if (rowingMachine == null) {
                    rowingMachine = new RowingMachine();
                }
            }
        }

        return rowingMachine;
    }

    @Override
    public void sleep(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    @Override
    public void message() {

    }
}
