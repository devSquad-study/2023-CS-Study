package main.observerPattern.subject;

import main.observerPattern.observer.StockPriceObserver;

public interface Subject {
    public void registerObserver(StockPriceObserver o);
    public void notifyObservers();
}
