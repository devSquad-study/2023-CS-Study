package market;

import client.Seller;
import order.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Market implements Purchasable, Sellable {

    private final Map<UUID, Seller> sellers;

    public Market() {
        this.sellers = new HashMap<>();
    }

    public Seller registerSeller(Seller seller) {
        sellers.put(seller.getId(), seller);
        return seller;
    }

    @Override
    public Order requestOrder(UUID sellerId) {
        assert sellers.get(sellerId) != null: "판매자를 찾을 수 없습니다.";
        return new Order(sellerId);
    }

    @Override
    public Order acceptOrder(Order order) {
        try {
            order.getState().accept(order);
            Thread.sleep(1000L);
            order.getState().accept(order);
            return order;
        } catch (Exception e) {
            return order;
        }
    }

    @Override
    public Order denyOrder(Order order) {
        order.getState().deny(order);
        return order;
    }

}
