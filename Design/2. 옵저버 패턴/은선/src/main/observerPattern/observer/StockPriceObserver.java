package main.observerPattern.observer;

public interface StockPriceObserver {
    void update(String stockName,double price);
}
