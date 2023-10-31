package main.observerPattern.stock;

import main.observerPattern.observer.StockPriceObserver;

import java.util.ArrayList;
import java.util.List;

public class StockPrice {
    private List<StockPriceObserver> stockPriceObservers;
    private String stockName;
    private double price;

    public StockPrice() {
        stockPriceObservers = new ArrayList<StockPriceObserver>();
    }

    public void registerObserver(StockPriceObserver o) {
        stockPriceObservers.add(o);
    }

    public void notifyObservers() {
        for (StockPriceObserver stockPriceObserver : stockPriceObservers) {
            stockPriceObserver.update(stockName, price);
        }
    }

    public void setStockPrice(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        notifyObservers(); // 변경된 주식 가격을 옵저버들에게 알림
    }
}
