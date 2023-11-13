package main.factoryPattern.beverage;

import main.factoryPattern.beverage.ingredient.Shot;

public class Espresso extends Beverage{

    public Espresso(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    void prepare() {
        shot = new Shot(1);
    }
}
