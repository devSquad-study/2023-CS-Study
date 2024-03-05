package server.view;

import server.context.UserInputScanner;
import server.controller.LoginController;
import server.model.Customer;

public class LoginView extends AbstractViewComponent {

    private final LoginController loginController;

    public LoginView() {
        this.loginController = new LoginController();
    }

    @Override
    public void render() {
        String id;
        String password;
        Customer customer;
        do {
            System.out.println("로그인 하세요.");
            System.out.print("ID: ");
            id = UserInputScanner.scan();
            System.out.print("PW: ");
            password = UserInputScanner.scan();
            customer = loginController.login(id, password);
        } while (customer == null);
        System.out.printf("%s님 안녕하세요.\n", customer.getName());
    }

}
