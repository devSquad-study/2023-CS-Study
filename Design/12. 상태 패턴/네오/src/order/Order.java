package order;

import order.state.DefaultOrderState;
import order.state.OrderState;

import java.util.UUID;

public class Order {

    private final UUID id;
    private final UUID sellerId;
    private OrderState state;

    public Order(UUID sellerId) {
        id = UUID.randomUUID();
        this.sellerId = sellerId;
        state = DefaultOrderState.NEW;
        System.out.println("새로운 주문을 생성합니다.");
        System.out.println(this);
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", sellerId=" + sellerId +
                ", state=" + state +
                '}';
    }

}
