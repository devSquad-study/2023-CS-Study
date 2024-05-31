package order;

public class SuccessState implements OrderState {
    @Override
    public void processOrder(Order order) {
        System.out.println("주문이 성공적으로 처리되었습니다.");
    }
}