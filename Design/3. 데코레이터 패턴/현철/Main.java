public class Main {
    public static void main(String[] args) {
        Car car = new Genesis();
        System.out.println(car.getDescription() + " $" + car.cost());

        car = new DigitalLight(car);
        car = new Nav(car);
        System.out.println(car.getDescription() + " $" + car.cost());

        Car car1 = new MercedesBenz();
        System.out.println(car1.getDescription() + " $" + car1.cost());
        car1 = new DigitalLight(car1);

        System.out.println(car1.getDescription() + " $" + car1.cost());
    }

}

