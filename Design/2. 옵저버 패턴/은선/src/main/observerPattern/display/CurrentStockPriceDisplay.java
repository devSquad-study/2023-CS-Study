package main.observerPattern.display;

import main.observerPattern.display.DisplayElement;
import main.observerPattern.observer.StockPriceObserver;
import main.observerPattern.stock.StockPrice;

public class CurrentStockPriceDisplay implements StockPriceObserver, DisplayElement {

    private String stockName;
    private double price;
    private StockPrice stockPrice;

    public CurrentStockPriceDisplay(StockPrice stockPrice) {
        this.stockPrice = stockPrice;
        stockPrice.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println(stockName + " 주식의 가격은 " + price);
    }

    @Override
    public void update(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        display(); // 주식 가격 업데이트 시 display() 메서드 호출
    }
}
