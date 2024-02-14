package order;

import product.Product;

import java.util.List;

public class NewState implements OrderState {
    @Override
    public void processOrder(Order order) {
        System.out.println("주문이 들어왔습니다.");
        order.setState(new PendingState());
    }
}
