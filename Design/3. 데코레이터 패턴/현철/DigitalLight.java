public class DigitalLight extends FuncDecorator{

    public DigitalLight(Car car) {
        this.car = car;
    }

    @Override
    public double cost() {
        return car.cost() + 150.3;
    }

    @Override
    public String getDescription() {
        return car.getDescription() + ", 디지털 라이트";
    }
}
