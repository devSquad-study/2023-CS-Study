package server.model;

import java.util.UUID;

public class Product {

    private final UUID id;
    private final Seller seller;
    private String name;
    private int price;

    public Product(Seller seller, String name, int price) {
        this.id = UUID.randomUUID();
        this.seller = seller;
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public Seller getSeller() {
        return seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "상품번호=" + id +
                " 판매자=" + seller.getName() +
                " 상품이름=" + name +
                " 가격=" + price;
    }

}
