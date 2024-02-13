package factory.beverage;

public class BeverageOrderSystem {
    public static void main(String[] args) {
        Cafe starbucks = new StarBucks();
        Cafe timHortons = new TimHortons();

        Beverage beverage = starbucks.makeBeverage("Tea");
        beverage = new Mocha(beverage);
        System.out.println("상혁이가 주문한" + beverage.getDescription() + " 가격: $" + beverage.cost());

        beverage = timHortons.makeBeverage("Coffee");
        beverage = new Whip(beverage);
        System.out.println(String.format("상혁이가 주문한 %s 가격: $%.1f", beverage.getDescription(), beverage.cost()));
    }
}
