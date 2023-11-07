package factory;

import beverage.Beverage;
import beverage.cafe.Americano;
import beverage.cafe.CafeLatte;
import beverage.cafe.Coffee;

import java.util.Map;

public class CoffeeFactory implements BeverageFactory {

    private final Map<Integer, Coffee> menus;

    public CoffeeFactory() {
        this.menus = Map.of(
                1, new Americano(),
                2, new CafeLatte()
        );
    }

    @Override
    public Beverage create(int index) {
        Beverage coffee = menus.get(index);
        if (coffee == null) {
            throw new RuntimeException();
        }
        return coffee;
    }

}
