package server.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Cart {

    private final List<Node> list;

    public Cart() {
        this.list = new ArrayList<>();
    }

    public void addToCart(Product product, int amount) {
        for (Node node : list) {
            if (node.productIdMatches(product.getId())) {
                node.addAmount(amount);
                return;
            }
        }
        list.add(new Node(product, amount));
    }

    public void removeFromCart(int index) {
        list.remove(index);
    }

    public void removeFromCart(int... indexes) {
        for (int index : indexes) {
            list.set(index, null);
        }
        list.removeIf(Objects::isNull);
    }

    public List<Node> getData() {
        return List.copyOf(list);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        list.forEach(node -> builder.append(node).append("\n"));
        return builder.toString();
    }

    public static class Node {
        private static final String TO_STRING_FORMAT = "id: %s name: %s price: %s amount: %s";

        private final Product product;
        private int amount;

        private Node(Product product, int amount) {
            this.product = product;
            this.amount = amount;
        }

        public boolean productIdMatches(UUID id) {
            return this.product.getId().equals(id);
        }

        public void addAmount(int amount) {
            this.amount += amount;
        }

        @Override
        public String toString() {
            return String.format(
                    TO_STRING_FORMAT,
                    product.getId(),
                    product.getName(),
                    product.getPrice() * amount,
                    amount
            );
        }
    }

}
