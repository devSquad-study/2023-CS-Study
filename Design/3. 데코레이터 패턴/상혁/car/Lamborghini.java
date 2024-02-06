package decorator.car;

public class Lamborghini extends Car {

    public Lamborghini() {
        description = "람보르기니";
    }

    @Override
    public double cost() {
        return 100.0;
    }

}
