package observer.stock;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject {
    private List<Observer> observers;
    private String stockName;
    private float stockPrice;

    public Stock() {
        this.observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void measurementsChanged() {
        notifyObserver();
    }

    public void setStock(String stockName, float stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        measurementsChanged();
    }

    public String getStockName() {
        return stockName;
    }

    public float getStockPrice() {
        return stockPrice;
    }
}
