package subject.stock;

import java.util.Objects;

public class Stock implements Comparable<Stock> {

    private final String name;
    private int price;

    public Stock(String name) {
        this.name = name;
        this.price = 100;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int amount) {
        if (this.price > 1) {
            this.price += amount;
            return;
        }
        if (amount > -1) {
            this.price += amount;
        }
    }

    @Override
    public int compareTo(Stock stock) {
        return this.name.compareTo(stock.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public boolean equals(Object stock) {
        if (stock instanceof Stock) {
            return this.name.equals(((Stock) stock).getName());
        }
        throw new RuntimeException("check instance's type.");
    }
}
