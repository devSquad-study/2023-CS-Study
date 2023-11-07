package factory;

import beverage.Beverage;
import beverage.tea.EarlGrey;
import beverage.tea.PepperMint;
import beverage.tea.Tea;

import java.util.Map;

public class TeaFactory implements BeverageFactory {

    private final Map<Integer, Tea> menus;

    public TeaFactory() {
        this.menus = Map.of(
                1, new EarlGrey(),
                2, new PepperMint()
        );
    }

    @Override
    public Beverage create(int index) {
        Beverage tea = menus.get(index);
        if (tea == null) {
            throw new RuntimeException();
        }
        return tea;
    }

}
