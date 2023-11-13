package beverageFactory;

import beverage.Beverage;

public interface BeverageFactory {
    Beverage createBeverage(String name);
}
