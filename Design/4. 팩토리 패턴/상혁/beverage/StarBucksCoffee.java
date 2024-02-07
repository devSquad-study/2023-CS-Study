package factory.beverage;

public class StarBucksCoffee extends Beverage {

    public StarBucksCoffee() {
        description = "스타벅스 커피";
    }

    @Override
    public double cost() {
        return 5.0;
    }
}
