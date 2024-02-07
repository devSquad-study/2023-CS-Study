package factory.beverage;

public class TimHortons extends Cafe {
    @Override
    Beverage makeBeverage(String type) {
        Beverage beverage = null;

        if (type.equals("Coffee")) {
            beverage = new TimHortonsCoffee();
        } else if (type.equals("Ade")) {
            beverage = new TimHortonsAde();
        } else if (type.equals("Tea")) {
            beverage = new TimHortonsTea();
        }

        return beverage;
    }
}
