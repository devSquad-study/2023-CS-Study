package decorator.car;

public abstract class CondimentDecorator extends Car {
    Car car;

    public abstract String getDescription();
}
