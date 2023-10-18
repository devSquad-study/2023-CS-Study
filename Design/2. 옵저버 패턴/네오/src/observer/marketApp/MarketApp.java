package observer.marketApp;

import observer.Observable;
import subject.stock.Stock;

import java.util.Set;

public abstract class MarketApp implements Observable {

    protected Set<Stock> stocks;

}
