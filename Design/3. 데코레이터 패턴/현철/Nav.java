public class Nav extends FuncDecorator{

    public Nav(Car car) {
        this.car = car;
    }

    @Override
    public double cost() {
        return car.cost() + 100.0;
    }

    @Override
    public String getDescription() {
        return car.getDescription() + ", 네비게이션";
    }
}
