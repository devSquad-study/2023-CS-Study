package beverage;

import beverage.Beverage;

public class CafeLatte implements Beverage {

    private final String name = "카페라떼";
    private final int cost = 3500;
    private final int size;

    public CafeLatte(int size){
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
