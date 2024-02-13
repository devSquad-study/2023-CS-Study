package factory.beverage;

public class StarBucksTea extends Beverage {
    public StarBucksTea() {
        description = "스타벅스 차";
    }

    @Override
    public double cost() {
        return 4.0;
    }
}
