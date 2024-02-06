package decorator.car;

public class Navigator extends CondimentDecorator {

    public Navigator(Car car) {
        this.car = car;
    }

    @Override
    public double cost() {
        return car.cost() + .50;
    }

    @Override
    public String getDescription() {
        return car.getDescription() + " ,네비게이터";
    }
}
