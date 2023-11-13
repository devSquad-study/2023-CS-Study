package cafe;

import beverage.Beverage;

import java.util.List;

public interface Cafe {
    List<Beverage> orderBeverage();
    void printReceipt(List<Beverage> berverages);
}
