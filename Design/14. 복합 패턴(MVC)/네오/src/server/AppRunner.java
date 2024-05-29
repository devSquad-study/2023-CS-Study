package server;

import server.context.ApplicationContext;
import server.model.Product;
import server.model.Seller;
import server.view.LoginView;
import server.view.MenuView;

public class AppRunner {

    private static final AppRunner instance = new AppRunner();

    private final LoginView loginView;
    private final MenuView menuView;

    private AppRunner() {
        this.loginView = new LoginView();
        this.menuView = new MenuView();
    }

    public static AppRunner getInstance() {
        return instance;
    }

    public void run() {
        System.out.println("Hello World!");

        // 판매자 등록
        Seller seller00 = new Seller("말랑상점");
        Seller seller01 = new Seller("단단상점");

        // 상품 등록 1
        Product product00 = new Product(seller00, "말랑 키링", 500);
        seller00.addProduct(product00, 300);
        ApplicationContext.addProduct(product00);

        // 상품 등록 2
        Product product01 = new Product(seller01, "단단 키링", 500);
        seller01.addProduct(product01, 500);
        ApplicationContext.addProduct(product01);

        while (ApplicationContext.isRun()) {
            if (ApplicationContext.getCustomer() == null) {
                loginView.render();
            }
            menuView.render();
            ApplicationContext.setRun(false);
        }
    }

}
