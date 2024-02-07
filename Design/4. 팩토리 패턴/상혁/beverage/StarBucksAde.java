package factory.beverage;

public class StarBucksAde extends Beverage {

    public StarBucksAde() {
        description = "스타벅스 에이드";
    }

    @Override
    public double cost() {
        return 3.0;
    }
}
