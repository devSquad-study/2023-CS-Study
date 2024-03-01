package server.controller;

import server.context.ApplicationContext;
import server.model.Product;

import java.util.Map;
import java.util.UUID;

public class ProductController {

    public Map<UUID, Product> getProducts() {
        return ApplicationContext.getProducts();
    }

    public void addToCart(String productId, int amount) throws IllegalArgumentException {
        ApplicationContext.findProductById(UUID.fromString(productId))
                .ifPresentOrElse(product -> {
                    if (product.getSeller().getStock(product.getId()) < amount) {
                        throw new IllegalArgumentException("재고가 부족합니다.");
                    }
                    ApplicationContext.getCustomer().getCart().addToCart(product, amount);
                }, () -> {
                    throw new IllegalArgumentException("상품을 찾을 수 없습니다.");
                });
    }

}
