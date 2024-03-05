package server.view;

import server.context.ApplicationContext;
import server.context.UserInputScanner;

public class MenuView extends AbstractViewComponent {

    public MenuView() {
        children.put("productList", new ProductListView());
        children.put("cart", new CartView());
    }

    @Override
    public void render() {
        while (ApplicationContext.isRun()) {
            System.out.println("""
                    메뉴를 선택해주세요.
                    1. 상품 목록
                    2. 장바구니 확인
                    0. 종료""");
            int input = getMenuNumber();
            switch (input) {
                case 0 -> ApplicationContext.setRun(false);
                case 1 -> children.get("productList").render();
                case 2 -> children.get("cart").render();
            }
        }
    }

    private int getMenuNumber() {
        try  {
            String value = UserInputScanner.scan();
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            return 999; // returns not valid number
        }
    }

}
