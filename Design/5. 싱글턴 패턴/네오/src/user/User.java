package user;

import data.Data;
import printer.MalangPrinter;
import printer.Printer;
import util.RandomIntegerGenerator;

public class User extends Thread {

    private final Printer printer;
    private final Schedule schedule;
    private final Data[] datum;

    public User(String name) {
        setName(name);
        this.printer = MalangPrinter.getInstance();
        int count = RandomIntegerGenerator.asInt(0, 3);
        this.schedule = new Schedule(count);
        this.datum = createDatum(count);
    }

    private Data[] createDatum(int count) {
        Data[] datum = new Data[count];
        for (int i = 0; i < count; i++) {
            datum[i] = new Data(this);
        }
        return datum;
    }

    @Override
    public void run() {
        for (int i = 0; i < schedule.count(); i++) {
            try {
                sleep(schedule.gaps()[i] * 1_000L);
                printer.request(datum[i]);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
