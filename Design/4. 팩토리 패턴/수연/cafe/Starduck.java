package cafe;

import beverage.Beverage;
import cafe.Cafe;

import java.util.ArrayList;
import java.util.List;

public class Starduck implements Cafe {

    private BeverageOrderSystem beverageOrderSystem = new BeverageOrderSystem();
    private BeverageFactory beverageFactory = new BeverageFacrotyOfFactory();

    @Override
    public List<Beverage> orderBeverage() {
        List<String> beverage = beverageOrderSystem.orderBerverage();
        List<Beverage> orderBeverage = new ArrayList<>();

        for(int i =0; i<beverage.size(); i++){
            orderBeverage.add(beverageFactory.createBeverage(beverage.get(i)));
        }

        return orderBeverage;
    }

    @Override
    public void printReceipt(List<Beverage> berverages) {
        beverageOrderSystem.printBerverageReceipt(berverages);
    }

    public void start(){
        List<Beverage> orders = orderBeverage();
        printReceipt(orders);
    }
}
