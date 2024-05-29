package server.view;


import server.context.UserInputScanner;
import server.controller.ProductController;
import server.model.Product;

import java.util.Map;
import java.util.UUID;

public class ProductListView extends AbstractViewComponent {

    private final ProductController productController;

    public ProductListView() {
        this.productController = new ProductController();
    }

    @Override
    public void render() {
        while (true) {
            System.out.println("상품 목록");
            Map<UUID, Product> products = productController.getProducts();
            products.values().forEach(System.out::println);
            String productId = scanProductId();
            int amount = scanAmount();
            try {
                productController.addToCart(productId, amount);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private String scanProductId() {
        System.out.println("장바구니에 담을 상품 번호를 입력해주세요.");
        return UserInputScanner.scan();
    }

    private int scanAmount() {
        while (true) {
            try {
                System.out.println("수량을 입력해주세요.");
                return Integer.parseInt(UserInputScanner.scan());
            } catch (NumberFormatException exception) {
                // ignore
            }
        }
    }

}
