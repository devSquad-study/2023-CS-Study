import DTO.OrderSheet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Controller controller = new Controller();

        OrderSheet orderSheet = new OrderSheet("변신 자동차","경기도 수원시","google@google.com");
        OrderSheet orderSheet1 = new OrderSheet("게임기 필통","경기도 수원시","google@google.com");
        OrderSheet orderSheet2 = new OrderSheet("곰돌이","경기도 수원시","google@google.com");
        OrderSheet orderSheet3 = new OrderSheet("화장대","경기도 수원시","google@google.com");
        OrderSheet orderSheet4 = new OrderSheet("변신 자동차","경기도 수원시","google@google.com");
        OrderSheet orderSheet5 = new OrderSheet("변신 자동차","경기도 수원시","google@google.com");
        OrderSheet orderSheet6 = new OrderSheet("변신 자동차","경기도 수원시","google@google.com");

        controller.isCkeckedAddress(orderSheet);
        controller.isCkeckedAddress(orderSheet1);
        controller.isCkeckedAddress(orderSheet2);
        controller.isCkeckedAddress(orderSheet3);
        controller.isCkeckedAddress(orderSheet4);
        controller.isCkeckedAddress(orderSheet5);
        controller.isCkeckedAddress(orderSheet6);

    }
}