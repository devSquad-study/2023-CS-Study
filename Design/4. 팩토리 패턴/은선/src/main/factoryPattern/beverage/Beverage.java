package main.factoryPattern.beverage;

import main.factoryPattern.beverage.ingredient.Milk;
import main.factoryPattern.beverage.ingredient.Shot;
import main.factoryPattern.beverage.ingredient.Water;

public abstract class Beverage {
    String name;
    int price;
    Shot shot;
    Milk milk;
    Water water;

    abstract void prepare();

    void cup() {
        System.out.println("컵에 음료를 담습니다.");
    }

    void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}


