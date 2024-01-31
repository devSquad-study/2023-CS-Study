package client;

import market.Purchasable;
import order.Order;

import java.util.UUID;

public class Customer {

    private final UUID id;
    private final Purchasable purchasable;

    public Customer(Purchasable purchasable) {
        this.id = UUID.randomUUID();
        this.purchasable = purchasable;
    }

    public Order request(UUID sellerId) {
        return purchasable.requestOrder(sellerId);
    }

}
