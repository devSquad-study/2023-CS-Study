package observer;

import subject.stock.Stock;

import java.util.Set;

public interface Observable {

    void update(Set<Stock> stocks);

}
