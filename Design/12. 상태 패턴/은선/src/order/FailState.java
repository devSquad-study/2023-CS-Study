package order;

public class FailState implements OrderState {
    @Override
    public void processOrder(Order order) {
        System.out.println("주문 처리에 실패하였습니다.");
    }
}
