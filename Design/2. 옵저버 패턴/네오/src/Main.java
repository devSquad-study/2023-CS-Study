import observer.marketApp.AlphaSecuritiesApp;
import observer.marketApp.BravoSecuritiesApp;
import observer.marketApp.CharlieSecuritiesApp;
import subject.stock.Stock;
import subject.stock.StockData;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        StockData data = new StockData();

        data.addNewStock(new Stock("stock01"));
        data.addNewStock(new Stock("stock02"));
        data.addNewStock(new Stock("stock03"));
        data.addNewStock(new Stock("stock04"));
        data.addNewStock(new Stock("stock05"));

        data.registerObserver(new AlphaSecuritiesApp());
        data.registerObserver(new BravoSecuritiesApp());
        data.registerObserver(new CharlieSecuritiesApp());

        data.run();
    }

}
