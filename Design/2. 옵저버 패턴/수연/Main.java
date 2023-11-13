import observer.Human;
import subject.StockManager;

public class Main {
    public static void main(String[] args) {
        StockManager stockManager = new StockManager();
        Human human = new Human(stockManager);

        stockManager.setStock(30);
        stockManager.setStock(20);
        stockManager.setStock(50);

    }
}
