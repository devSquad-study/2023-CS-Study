package decorator.car;

public class Sunroof extends CondimentDecorator {
    
    @Override
    public double cost() {
        return car.cost() + 0.80;
    }

    @Override
    public String getDescription() {
        return car.getDescription() + " ,선루프";
    }
}
