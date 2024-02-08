package market;

import order.Order;

public interface Sellable {

    Order acceptOrder(Order order);
    Order denyOrder(Order order);

}
