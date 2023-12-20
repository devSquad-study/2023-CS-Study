import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class GasStove implements Device {
    private ScheduledExecutorService scheduler;

    @Override
    public void turnOn() {
        System.out.println("가스레인지 on.");

        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(this::turnOff, 5, TimeUnit.MINUTES);
    }

    @Override
    public void turnOff() {
        System.out.println("가스레인지 off.");

        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
        }
    }
}
