import client.Customer;
import client.Seller;
import market.Market;
import order.Order;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Market market = new Market();
        Seller seller01 = market.registerSeller(new Seller(market));
        Customer customer = new Customer(market);

        Order order01 = customer.request(seller01.getId());
        sleep(1000);
        seller01.receiveOrder(order01);

        Seller seller02 = market.registerSeller(new Seller(market, 0));

        Order order02 = customer.request(seller02.getId());
        sleep(1500);
        seller02.receiveOrder(order02);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
