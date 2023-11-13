package observer.marketApp;

import observer.Notifiable;
import subject.stock.Stock;

import java.util.Set;

public class CharlieSecuritiesApp extends MarketApp implements Notifiable {

    @Override
    public void alert() {
        this.stocks.parallelStream()
                .forEachOrdered(stock -> System.out.println(
                        this.getClass().getSimpleName()
                                + " - "
                                + stock.getName()
                                + ": "
                                + stock.getPrice()
                ));
    }

    @Override
    public void update(Set<Stock> stocks) {
        this.stocks = stocks;
        alert();
    }

}
