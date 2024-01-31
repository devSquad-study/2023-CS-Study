package market;

import order.Order;

import java.util.UUID;

public interface Purchasable {

    Order requestOrder(UUID sellerId);

}
