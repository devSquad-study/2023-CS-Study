package server.controller;

import server.context.ApplicationContext;
import server.model.Customer;

public class LoginController {

    public Customer login(String id, String password) {
        Customer customer = new Customer("김고객");
        ApplicationContext.setCustomer(customer);
        return customer; // 임시 반환값
    }

}
