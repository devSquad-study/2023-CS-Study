package factory.command;

import customer.Customer;
import factory.toy.Toy;

import java.util.UUID;

public record OrderSheet(
        UUID orderId,
        Toy toy,
        String address,
        String phone
) {
    public OrderSheet(Toy toy, Customer customer) {
        this(
                UUID.randomUUID(),
                toy,
                customer.getAddress(),
                customer.getPhone()
        );
    }
}
