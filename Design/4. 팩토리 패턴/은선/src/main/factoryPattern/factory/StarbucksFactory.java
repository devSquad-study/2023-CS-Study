package main.factoryPattern.factory;

import main.factoryPattern.beverage.Americano;
import main.factoryPattern.beverage.Espresso;
import main.factoryPattern.beverage.Latte;

public class StarbucksFactory implements BeverageFactory {
    @Override
    public Americano createAmericano() {
        return new Americano("스타벅스 아메리카노", 4500);
    }

    @Override
    public Latte createLatte() {
        return new Latte("스타벅스 라떼", 5100);
    }

    @Override
    public Espresso createEspresso() {
        return new Espresso("스타벅스 에스프레소", 2400);
    }
}