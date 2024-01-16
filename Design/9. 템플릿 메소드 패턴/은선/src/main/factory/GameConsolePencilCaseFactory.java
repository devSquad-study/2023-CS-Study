package main.factory;

public class GameConsolePencilCaseFactory extends ToyFactory {
    @Override
    void makeToy() {
        System.out.println("게임기 필통을 만드는 중...");
    }

    @Override
    void notifyCustomerNotAvailabe() {
        System.out.println("[메세지] 주문취소 : 게임기 필통");
        System.out.println("[메세지] 죄송합니다. 해당 지역으로는 배송이 불가능합니다.");
    }
}