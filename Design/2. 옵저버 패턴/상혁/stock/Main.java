package observer.stock;

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();

        CurrentPriceDisplay currentDisplay = new CurrentPriceDisplay(stock);

        stock.setStock("네이버", 8000.0f);
    }
}
