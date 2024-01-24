package factory;

import factory.command.OrderSheet;
import factory.toy.Toy;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public abstract class AbstractToyFactory {

    protected void makeToy(UUID orderId, Toy toy) {
        System.out.printf("[%s] [%s] %s를 만듭니다.\n", new Date(), orderId, toy.name());
        sleep();
    }

    protected void packToy(UUID orderId, Toy toy) {
        System.out.printf("[%s] [%s] %s를 포장합니다.\n", new Date(), orderId, toy.name());
        sleep();
    }

    protected void deliver(OrderSheet orderSheet) {
        System.out.printf(
                 "[%s] [%s] %s를 %s로 배송합니다. 연락처: %s\n",
                new Date(),
                orderSheet.orderId(),
                orderSheet.toy().name(),
                orderSheet.address(),
                orderSheet.phone()
        );
        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(new Random().nextLong(5, 30) * 1_00L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
