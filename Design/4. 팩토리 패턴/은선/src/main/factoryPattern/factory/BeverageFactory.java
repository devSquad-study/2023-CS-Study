package main.factoryPattern.factory;

import main.factoryPattern.beverage.Americano;
import main.factoryPattern.beverage.Beverage;
import main.factoryPattern.beverage.Espresso;
import main.factoryPattern.beverage.Latte;

public interface BeverageFactory {
    Americano createAmericano();
    Latte createLatte();
    Espresso createEspresso();

}

