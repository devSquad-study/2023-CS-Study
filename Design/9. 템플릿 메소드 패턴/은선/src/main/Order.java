package main;

import main.factory.*;

public class Order {
    private String toyOrdered;
    private String customerAddress;
    private String customerPhoneNumber;

    public Order(String toyOrdered, String customerAddress, String customerPhoneNumber) {
        this.toyOrdered = toyOrdered;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getToyOrdered() {
        return toyOrdered;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public ToyFactory createFactory() {
        if ("곰돌이".equals(toyOrdered)) {
            return new BearToyFactory();
        } else if ("변신 자동차".equals(toyOrdered)) {
            return new TransformingCarFactory();
        } else if ("콩순이 의사놀이".equals(toyOrdered)) {
            return new KongsunDoctorFactory();
        } else if ("게임기 필통".equals(toyOrdered)) {
            return new GameConsolePencilCaseFactory();
        } else {
            // 다른 장난감에 대한 처리 로직 추가
            return null;
        }
    }
}
