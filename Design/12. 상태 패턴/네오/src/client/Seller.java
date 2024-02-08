package client;

import market.Sellable;
import order.Order;
import order.state.DefaultOrderState;

import java.util.UUID;

public class Seller implements Comparable<Seller> {

    private final UUID id;
    private final Sellable sellable;
    private int stock;

    public Seller(Sellable sellable) {
        this.id = UUID.randomUUID();
        this.sellable = sellable;
        this.stock = 10;
    }

    public Seller(Sellable sellable, int initialStock) {
        this.id = UUID.randomUUID();
        this.sellable = sellable;
        this.stock = initialStock;
    }

    public UUID getId() {
        return id;
    }

    public synchronized void receiveOrder(Order order) {
        assert order.getState() == DefaultOrderState.NEW;
        if (stock > 0) {
            stock--;
            sellable.acceptOrder(order);
            return;
        }
        sellable.denyOrder(order);
        throw new IllegalStateException("재고가 부족합니다.");
    }

    @Override
    public int compareTo(Seller seller) {
        return this.id.compareTo(seller.id);
    }

}
