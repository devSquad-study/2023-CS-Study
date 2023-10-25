package src;

import src.car.Car;
import src.car.option.impl.ABS;
import src.car.option.impl.AroundView;
import src.car.option.impl.Navigation;
import src.car.segment.SegmentA;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!!!");

        Car car01 = new SegmentA();
        System.out.println("\ncar data");
        System.out.println(car01.describe());
        System.out.println("price: " + String.format("$ %,d", car01.cost()));

        car01 = new Navigation(car01);
        System.out.println("\ncar data");
        System.out.println(car01.describe());
        System.out.println("price: " + String.format("$ %,d", car01.cost()));

        car01 = new AroundView(car01);
        System.out.println("\ncar data");
        System.out.println(car01.describe());
        System.out.println("price: " + String.format("$ %,d", car01.cost()));

        car01 = new ABS(car01);
        System.out.println("\ncar data");
        System.out.println(car01.describe());
        System.out.println("price: " + String.format("$ %,d", car01.cost()));
    }

}
