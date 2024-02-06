package decorator.car;

public class Main {
    public static void main(String[] args) {
        Car car = new Ferrari();
        System.out.println(car.getDescription() + " $" + car.cost());

        Car car1 = new Lamborghini();
        car1 = new Navigator(car1);
        System.out.println(car1.getDescription() + " $" + car1.cost());
    }
}
