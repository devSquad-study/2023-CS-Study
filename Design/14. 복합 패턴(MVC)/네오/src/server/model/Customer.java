package server.model;

import java.util.UUID;

public class Customer {

    private final UUID id;
    private String name;
    private final Cart cart;

    public Customer() {
        this.id = UUID.randomUUID();
        this.cart = new Cart();
    }

    public Customer(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.cart = new Cart();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cart=" + cart +
                '}';
    }

}
