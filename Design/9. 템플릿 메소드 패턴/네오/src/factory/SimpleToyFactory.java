package factory;

import factory.command.OrderSheet;

import java.util.Date;

public class SimpleToyFactory
        extends AbstractToyFactory
        implements ToyFactory {

    @Override
    public void takeOrder(OrderSheet orderSheet) {
        System.out.printf("[%s] [%s] 주문을 받았습니다.\n", new Date(), orderSheet.orderId());
        makeToy(orderSheet.orderId(), orderSheet.toy());
        packToy(orderSheet.orderId(), orderSheet.toy());
        deliver(orderSheet);
    }

}
