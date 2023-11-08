package main.factoryPattern.factory;

import main.factoryPattern.beverage.Americano;
import main.factoryPattern.beverage.Espresso;
import main.factoryPattern.beverage.Latte;

public class TwosomePlaceFactory implements BeverageFactory {
    @Override
    public Americano createAmericano() {
        return new Americano("투썸플레이스 아메리카노", 4200);
    }

    @Override
    public Latte createLatte() {
        return new Latte("투썸플레이스 라떼",9800);
    }

    @Override
    public Espresso createEspresso() {
        return new Espresso("투썸플레이스 에스프레소",3000);
    }
}