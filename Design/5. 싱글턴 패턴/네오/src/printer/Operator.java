package printer;

import data.Data;
import ui.Logger;
import ui.SimpleLogger;
import ui.Type;

import java.time.Instant;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Operator implements Runnable {

    private final Lock lock;
    private final Queue<Data> queue;
    private final Logger logger;

    public Operator(Queue<Data> queue) {
        this.lock = new ReentrantLock();
        this.queue = queue;
        this.logger = new SimpleLogger();
    }

    public boolean tryLock() {
        return lock.tryLock();
    }

    @Override
    public void run() {
        while (!queue.isEmpty()) {
            this.print(queue.poll());
        }
        lock.unlock();
    }

    private void print(Data data) {
        for (int i = 0; i < data.body().pages(); i++) {
            try {
                logger.log(
                        Type.PRINT,
                        Instant.now(),
                        data.header().priority(),
                        data.body().title(),
                        i + 1,
                        data.body().pages()
                );
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
