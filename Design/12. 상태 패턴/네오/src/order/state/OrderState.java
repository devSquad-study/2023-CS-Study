package order.state;

import order.Order;

public interface OrderState {

    void accept(Order order);
    void deny(Order order);

}
