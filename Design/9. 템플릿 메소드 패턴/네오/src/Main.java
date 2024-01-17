import customer.Customer;
import factory.SimpleToyFactory;
import factory.ToyFactory;
import factory.toy.Toy;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ToyFactory factory = new SimpleToyFactory();
        List<Customer> customers = List.of(
                new Customer("말랑시 말랑구 말랑동 말랑말랑", "01011112222"),
                new Customer("물컹시 물컹구 물컹동 물컹물컹", "01022223333"),
                new Customer("단단시 단단구 단단동 단단단단", "01033334444")
        );

        Toy[] toys = Toy.values();
        customers.parallelStream().forEach(customer -> {
            Toy toy = toys[new Random().nextInt(0, toys.length)];
            factory.takeOrder(customer.getOrderSheet(toy));
        });
    }
}