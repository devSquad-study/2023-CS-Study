package observer.stock;

import observer.weather.DisplayElement;

public class CurrentPriceDisplay implements Observer, DisplayElement {
    private String stockName;
    private float stockPrice;
    private Stock stock;

    public CurrentPriceDisplay(Stock stock) {
        this.stock = stock;
        stock.registerObserver(this);
    }

    @Override
    public void update() {
        this.stockName = stock.getStockName();
        this.stockPrice = stock.getStockPrice();
        display();
    }

    @Override
    public void display() {
        System.out.println("종목 이름: " + stockName + " 현재 가격: " + stockPrice);
    }
}
