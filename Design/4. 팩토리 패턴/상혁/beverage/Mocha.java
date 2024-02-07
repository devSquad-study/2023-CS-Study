package factory.beverage;

public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + .50;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " ,모카";
    }
}
