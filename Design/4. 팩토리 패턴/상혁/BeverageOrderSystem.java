import java.util.ArrayList;
import java.util.List;

public class BeverageOrderSystem {
    private List<Order> orders;

    public BeverageOrderSystem() {
        this.orders = new ArrayList<>();
    }

    public void placeOrder(String beverageName, int quantity) {
        Beverage beverage = BeverageFactory.createBeverage(beverageName);
        if (beverage != null) {
            Order order = new Order(beverage, quantity);
            orders.add(order);
        } else {
            System.out.println("존재하지 않는 음료입니다: " + beverageName);
        }
    }

    public void printOrderSummary() {
        double totalAmount = 0.0;

        System.out.println("주문 내역:");
        for (Order order : orders) {
            System.out.println(order.getBeverage().getName() + " x " + order.getQuantity() + " = $" + order.getTotalPrice());
            totalAmount += order.getTotalPrice();
        }
        System.out.println("총 주문 금액: $" + totalAmount);
    }
}
