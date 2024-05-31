package order;

import exception.OutOfStockException;
import product.Product;

public class PendingState implements OrderState {
    @Override
    public void processOrder(Order order) {
        try {
            // 주문 처리 로직
            System.out.println("주문을 처리중입니다.");

            // 주문 상품 중 재고가 부족한 상품이 있는지 확인
            for (Product product : order.getProducts()) {
                if (product.getStock() < 1) {
                    // 재고 부족 시 예외 발생
                    throw new OutOfStockException(product.getName() + " 재고가 부족합니다.");
                }
                System.out.println(product.getName() + " " + product.getStock());
            }

            // 주문이 성공적으로 처리되면 Success 상태로 전이
            order.setState(new SuccessState());
        } catch (OutOfStockException e) {
            // 재고 부족 시 주문이 실패하고 Fail 상태로 전이
            System.out.println(e.getMessage()); // 예외 메시지 출력 추가
            order.setState(new FailState());

        }
    }
}