package decorator.car;

public class Ferrari extends Car {

    public Ferrari() {
        description = "페라리";
    }

    @Override
    public double cost() {
        return 80.0;
    }
}
