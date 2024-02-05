package customer;

import factory.command.OrderSheet;
import factory.toy.Toy;

public class Customer {

    private String address;
    private String phone;

    public Customer(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public OrderSheet getOrderSheet(Toy toy) {
        return new OrderSheet(toy, this);
    }

}
