package shop;

import beverage.Beverage;
import factory.BeverageFactory;
import factory.CoffeeFactory;

public class CoffeeShop implements Shop {

    private final BeverageFactory factory;

    public CoffeeShop() {
        this.factory = new CoffeeFactory();
    }

    @Override
    public Beverage make(int index) {
        Beverage coffee = factory.create(index);
        coffee.make();
        return coffee;
    }

}
