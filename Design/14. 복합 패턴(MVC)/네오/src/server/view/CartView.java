package server.view;

import server.context.ApplicationContext;

public class CartView extends AbstractViewComponent {

    @Override
    public void render() {
        System.out.println("장바구니 목록");
        System.out.println(ApplicationContext.getCustomer().getCart().toString());
    }

}
