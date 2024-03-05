package server.controller;

import server.context.ApplicationContext;
import server.model.Cart;

public class CartController {

    public Cart getCart() {
        return ApplicationContext.getCustomer().getCart();
    }

}
