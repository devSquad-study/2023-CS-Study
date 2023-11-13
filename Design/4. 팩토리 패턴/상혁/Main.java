public class Main {
    public static void main(String[] args) {
        BeverageOrderSystem orderSystem = new BeverageOrderSystem();

        // 고객 1 주문
        orderSystem.placeOrder("아메리카노", 2);
        orderSystem.placeOrder("라떼", 1);

        // 고객 2 주문
        orderSystem.placeOrder("에스프레소", 3);

        // 주문 내역 출력
        orderSystem.printOrderSummary();
    }
}
