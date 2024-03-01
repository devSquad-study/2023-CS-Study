package server.context;

import server.model.Customer;
import server.model.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ApplicationContext {

    private static final Map<UUID, Product> products = new HashMap<>(); // 등록된 상품 목록
    private static Customer customer; // 현재 로그인 한 고객 정보
    private static boolean run = true; // 프로그램 실행 정보

    public static Map<UUID, Product> getProducts() {
        return products;
    }

    public static Optional<Product> findProductById(UUID id) {
        return Optional.ofNullable(products.get(id));
    }

    public static void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer value) {
        customer = value;
    }

    public static boolean isRun() {
        return run;
    }

    public static void setRun(boolean run) {
        ApplicationContext.run = run;
    }

}
