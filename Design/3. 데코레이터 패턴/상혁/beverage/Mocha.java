package decorator.beverage;

public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    //    @Override
//    public double cost() {
//        double cost = beverage.cost();
//        if (beverage.getSize() == Size.TALL) {
//            cost += .10;
//        } else if (beverage.getSize() == Size.GRANDE) {
//            cost += .15;
//        } else if (beverage.getSize() == Size.VENTI) {
//            cost += .20;
//        }
//        return cost;
//    }
    @Override
    public double cost() {
        double cost = beverage.cost();
        Size size = beverage.getSize();

        double[] sizeCosts = {0.10, 0.15, 0.20};

        int sizeIndex = size.ordinal();

        double sizeCost = sizeIndex >= 0 && sizeIndex < sizeCosts.length ? sizeCosts[sizeIndex] : 0.0;

        return cost + sizeCost;
    }


    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 모카";
    }
}
