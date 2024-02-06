package decorator.beverage;

public class Main {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);

        //beverage2.description = "하우스 블렌드 커피"
        /*
        형태:
        Whip ( Mocha ( Mocha ( HouseBlend ) ) )
        과정:
        1. 제일 바깥쪽의 Whip의 getDescription 호출 -> Mocha -> Mocha -> HouseBlend의 getDescription 호출
        2. 제일 안쪽부터 차례대로 반환
        */
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
