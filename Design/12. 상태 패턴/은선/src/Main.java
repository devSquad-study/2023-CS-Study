import order.Order;
import product.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 문구점
        Product pen = new Product("볼펜", 5);
        Product eraser = new Product("지우개", 10);

        // 주문
        List<Product> orderPorductList1 = new ArrayList<>();
        orderPorductList1.add(pen);
        orderPorductList1.add(eraser);

        // 주문이 들어옴
        Order order = new Order(orderPorductList1);
        order.processOrder();

        System.out.println(" ");
        // 재고없는 연필을 주문시
        List<Product> orderPorductList2 = new ArrayList<>();
        Product pencil = new Product("연필", 0); // 연필 재고없음
        orderPorductList2.add(pencil);
        Order order2 = new Order(orderPorductList2);
        order2.processOrder();
    }
}