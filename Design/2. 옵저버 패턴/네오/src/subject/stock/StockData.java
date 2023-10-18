package subject.stock;

import observer.Observable;
import subject.Publisher;

import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;

public class StockData implements Publisher {

    private final Set<Stock> stocks;
    private final Set<Observable> observers;

    public StockData() {
        this.stocks = new CopyOnWriteArraySet<>();
        this.observers = new CopyOnWriteArraySet<>();
    }

    public void addNewStock(Stock stock) {
        this.stocks.add(stock);
    }

    public void run() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                stocks.parallelStream().forEach(stock -> stock.setPrice(new Random().nextInt(-1, 2)));
                notifyObserver();
            }
        }, 0, 5_000);
    }

    @Override
    public void registerObserver(Observable observable) {
        observers.add(observable);
    }

    @Override
    public void withdrawObserver(Observable observable) {
        observers.remove(observable);
    }

    @Override
    public void notifyObserver() {
        observers.parallelStream().forEach(observer -> observer.update(this.stocks));
    }

}
