package main.factoryPattern.beverage;

import main.factoryPattern.beverage.ingredient.Milk;
import main.factoryPattern.beverage.ingredient.Shot;

public class Latte extends Beverage {
    public Latte(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    void prepare() {
        shot = new Shot(1);
        milk = new Milk();
    }
}
