package factory.beverage;

public class StarBucks extends Cafe {
    @Override
    Beverage makeBeverage(String type) {
        Beverage beverage = null;

        if (type.equals("Coffee")) {
            beverage = new StarBucksCoffee();
        } else if (type.equals("Ade")) {
            beverage = new StarBucksAde();
        } else if (type.equals("Tea")) {
            beverage = new StarBucksTea();
        }

        return beverage;
    }
}
