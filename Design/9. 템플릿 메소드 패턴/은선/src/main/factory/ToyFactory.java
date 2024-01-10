package main.factory;

public abstract class ToyFactory {

    public final void prepareToy(String address) {
        if (checkDeliveryArea(address)) {
            makeToy();
            deliverToy();
            notifyCustomerAvailabe();
        }
        else {
            notifyCustomerNotAvailabe();
        }
    }

    abstract void makeToy();

    boolean checkDeliveryArea(String address) {
        // 주소에 "서울"이나 "경기도"가 포함되어 있는지 확인
        return address.contains("서울") || address.contains("경기도");
    }

    void deliverToy() {
        // 모든 장난감의 기본 배송 로직
        System.out.println("장난감을 배송 중입니다...");
    }

    void notifyCustomerAvailabe() {
        System.out.println("[메세지] 배송이 완료 되었습니다.");
    }
    abstract void notifyCustomerNotAvailabe();
}