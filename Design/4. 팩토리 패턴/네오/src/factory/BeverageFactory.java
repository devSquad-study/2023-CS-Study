package factory;

import beverage.Beverage;

public interface BeverageFactory {

    Beverage create(int index);

}
