import shop.CoffeeShop;
import shop.Shop;
import shop.TeaShop;

public class Main {
    public static void main(String[] args) {
        Shop shop = new CoffeeShop();

        System.out.println(shop.make(1));
        System.out.println(shop.make(2));

        shop = new TeaShop();

        System.out.println(shop.make(1));
        System.out.println(shop.make(2));
    }
}