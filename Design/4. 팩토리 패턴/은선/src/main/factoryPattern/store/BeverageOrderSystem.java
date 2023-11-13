package main.factoryPattern.store;

import main.factoryPattern.beverage.Beverage;
import main.factoryPattern.factory.BeverageFactory;

import java.util.HashMap;
import java.util.Map;

public class BeverageOrderSystem {
    private Map<String, Map<String, Integer>> orderListByCafe;
    private Map<String, BeverageFactory> factoryMap;

    public BeverageOrderSystem() {
        orderListByCafe = new HashMap<>();
        factoryMap = new HashMap<>();
    }

    public void addFactory(String cafeName, BeverageFactory factory) {
        factoryMap.put(cafeName, factory);
    }

    public void orderBeverage(String cafeName, String beverageName, int count) {
        BeverageFactory factory = factoryMap.get(cafeName);
        if (factory != null) {
            Beverage beverage = null;
            switch (beverageName) {
                case "아메리카노":
                    beverage = factory.createAmericano();
                    break;
                case "라떼":
                    beverage = factory.createLatte();
                    break;
                case "에스프레소":
                    beverage = factory.createEspresso();
                    break;
            }

            if (beverage != null) {
                orderListByCafe
                        .computeIfAbsent(cafeName, k -> new HashMap<>()) // cafeName에 해당하는 맵이 존재하지 않으면 빈 맵으로 초기화, 존재하면 그대로 저장
                        .merge(beverageName, count, Integer::sum); // 이미 존재하는 값과 새로운 값을 더해서 최종값 계산, 주문 수량 누적가능

                System.out.println(cafeName + ": " + count + "잔의 " + beverageName + " 주문이 완료되었습니다.");
            } else {
                System.out.println(beverageName + "은(는) 메뉴에 없는 음료입니다.");
            }
        } else {
            System.out.println(cafeName + "은(는) 없는 카페입니다.");
        }
    }

    public void printOrderSummary() {
        System.out.println("주문 내역:");
        int totalAmount = 0;
        for (Map.Entry<String, Map<String, Integer>> cafeEntry : orderListByCafe.entrySet()) {
            String cafeName = cafeEntry.getKey();
            Map<String, Integer> cafeOrderList = cafeEntry.getValue();
            for (Map.Entry<String, Integer> entry : cafeOrderList.entrySet()) {
                String beverageName = entry.getKey();
                int orderCount = entry.getValue();
                BeverageFactory factory = factoryMap.get(cafeName); // 현재 카페에 해당하는 팩토리 가져옴

                if (factory != null) {
                    Beverage beverage = null;
                    switch (beverageName) {
                        case "아메리카노":
                            beverage = factory.createAmericano();
                            break;
                        case "라떼":
                            beverage = factory.createLatte();
                            break;
                        case "에스프레소":
                            beverage = factory.createEspresso();
                            break;
                    }

                    if (beverage != null) {
                        int price = (int) beverage.getPrice();
                        int subTotal = price * orderCount;
                        System.out.println(cafeName + " " + beverageName + " x" + orderCount + " - " + subTotal + "원");
                        totalAmount += subTotal;
                    }
                }
            }
        }
        System.out.println("총 주문 금액: " + totalAmount + "원");
    }
}
