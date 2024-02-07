package factory.beverage;

public abstract class Cafe {
    public Beverage orderBeverage(String type) {
        Beverage beverage;

        beverage = makeBeverage(type);

        return beverage;
    }

    abstract Beverage makeBeverage(String type);
}
