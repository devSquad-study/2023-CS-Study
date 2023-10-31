public class Order {
    private Beverage beverage;
    private int quantity;

    public Order(Beverage beverage, int quantity) {
        this.beverage = beverage;
        this.quantity = quantity;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return beverage.getPrice() * quantity;
    }
}
