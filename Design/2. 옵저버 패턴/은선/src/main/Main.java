package main;

import main.observerPattern.display.CurrentStockPriceDisplay;
import main.observerPattern.stock.StockPrice;

public class Main {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();

        CurrentStockPriceDisplay currentStockPriceDisplay = new CurrentStockPriceDisplay(stockPrice);

        stockPrice.setStockPrice("A기업", 90000);
        stockPrice.setStockPrice("B기업", 10000);
        stockPrice.setStockPrice("A기업", 50000);
        stockPrice.setStockPrice("C기업", 50000);
    }
}