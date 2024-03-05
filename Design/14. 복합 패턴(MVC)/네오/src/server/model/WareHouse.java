package server.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class WareHouse {

    private final Map<UUID, Stock> stocks; // UUID: productId, Stock: stockData

    public WareHouse() {
        this.stocks = new HashMap<>();
    }

    public int getStock(UUID productId) {
        return stocks.get(productId).amount;
    }

    public void add(Product product, int amount) {
        Optional.ofNullable(stocks.get(product.getId()))
                .ifPresentOrElse(
                        stock -> stock.add(amount),
                        () -> stocks.put(product.getId(), new Stock(product, amount))
                );
    }

    public void sub(UUID productId, int amount) {
        Optional.ofNullable(stocks.get(productId))
                .ifPresentOrElse(stock -> stock.sub(amount), () -> {
                    throw new IllegalStateException("상품을 찾을 수 없습니다.");
                });
    }

    public void remove(UUID productId) {
        stocks.remove(productId);
    }

    public static class Stock {
        private static final String TO_STRING_FORMAT = "id: %s name: %s price: %s amount: %s";

        private final Product product;
        private int amount;

        private Stock(Product product, int amount) {
            this.product = product;
            this.amount = amount;
        }

        public Product getProduct() {
            return product;
        }

        public int getAmount() {
            return amount;
        }

        public void add(int amount) {
            this.amount += amount;
        }

        public void sub(int amount) {
            if (amount > this.amount) {
                throw new IllegalStateException("재고 수량이 부족합니다.");
            }
            this.amount -= amount;
        }

        @Override
        public String toString() {
            return String.format(
                    TO_STRING_FORMAT,
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    amount
            );
        }
    }

}
