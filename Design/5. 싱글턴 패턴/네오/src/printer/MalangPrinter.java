package printer;

import data.Data;
import ui.Logger;
import ui.SimpleLogger;
import ui.Type;

import java.time.Instant;
import java.util.PriorityQueue;
import java.util.Queue;

public class MalangPrinter implements Printer {

    private volatile static MalangPrinter INSTANCE;
    private final Queue<Data> queue;
    private final Operator operator;
    private final Logger logger;

    private MalangPrinter() {
        this.queue = new PriorityQueue<>();
        this.operator = new Operator(queue);
        this.logger = new SimpleLogger();
    }

    public static MalangPrinter getInstance() {
        if (INSTANCE == null) {
            synchronized (MalangPrinter.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MalangPrinter();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void request(Data data) {
        synchronized (this) {
            logger.log(
                    Type.REQUEST,
                    Instant.now(),
                    data.header().priority().name(),
                    data.requester().getName(),
                    data.body().pages()
            );
            queue.add(data);
        }
        if (operator.tryLock()) {
            operator.run();
            return;
        }
        logger.log(Type.ENQUEUE, Instant.now(), data.header().priority(), data.requester().getName());
    }

}
