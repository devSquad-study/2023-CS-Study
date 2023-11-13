import java.util.HashMap;
import java.util.Map;

public class BeverageFactory {
    private static Map<String, Beverage> beverages = new HashMap<>();

    static {
        beverages.put("아메리카노", new Beverage("아메리카노", 3.0));
        beverages.put("라떼", new Beverage("라떼", 4.0));
        beverages.put("에스프레소", new Beverage("에스프레소", 2.5));
    }

    public static Beverage createBeverage(String name) {
        return beverages.get(name);
    }
}
