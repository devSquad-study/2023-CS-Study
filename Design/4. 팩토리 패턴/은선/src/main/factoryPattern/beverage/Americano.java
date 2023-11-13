package main.factoryPattern.beverage;

import main.factoryPattern.beverage.ingredient.Shot;
import main.factoryPattern.beverage.ingredient.Water;

public class Americano extends Beverage {
    public Americano(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    void prepare() {
        shot = new Shot(2);
        water = new Water();
    }
}