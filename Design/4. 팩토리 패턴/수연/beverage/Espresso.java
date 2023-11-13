package beverage;

import beverage.Beverage;

public class Espresso implements Beverage {

    private final String name = "에소프레소";
    private final int cost = 3500;
    private final int size;

    public Espresso(int size){
        this.size = size;
    }

    @Override
    public int cost() {
        return this.cost * size;
    }

    @Override
    public String toString() {
        return name +"              "+ size;
    }
}
