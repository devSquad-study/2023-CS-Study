package shop;

import beverage.Beverage;
import factory.BeverageFactory;
import factory.CoffeeFactory;
import factory.TeaFactory;

public class TeaShop implements Shop {

    private final BeverageFactory factory;

    public TeaShop() {
        this.factory = new TeaFactory();
    }

    @Override
    public Beverage make(int index) {
        Beverage tea = factory.create(index);
        tea.make();
        return tea;
    }

}
