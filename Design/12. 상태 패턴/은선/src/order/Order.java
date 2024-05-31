package order;

import product.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products;
    private OrderState state;

    public Order(List<Product> products) {
        this.products = products;
        this.state = new NewState();
    }

    public void processOrder() {
        state.processOrder(this);
    }

    public void setState(OrderState state) {
        this.state = state;
        this.processOrder();
    }

    public List<Product> getProducts() {
        return products;
    }
}
