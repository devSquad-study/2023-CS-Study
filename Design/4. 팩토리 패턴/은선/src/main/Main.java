package main;

import main.factoryPattern.factory.BeverageFactory;
import main.factoryPattern.factory.StarbucksFactory;
import main.factoryPattern.factory.TwosomePlaceFactory;
import main.factoryPattern.store.BeverageOrderSystem;

public class Main {
    public static void main(String[] args) {
        // BeverageFactory 생성
        BeverageFactory starbucksFactory = new StarbucksFactory();
        BeverageFactory twosomePlaceFactory = new TwosomePlaceFactory();

        // 주문 시스템 초기화
        BeverageOrderSystem orderSystem = new BeverageOrderSystem();

        // 카페 등록
        orderSystem.addFactory("스타벅스", starbucksFactory);
        orderSystem.addFactory("투썸플레이스", twosomePlaceFactory);

        // 음료 주문
        orderSystem.orderBeverage("스타벅스", "아메리카노", 2);
        orderSystem.orderBeverage("스타벅스", "라떼", 1);
        orderSystem.orderBeverage("투썸플레이스", "아메리카노", 3);
        orderSystem.orderBeverage("투썸플레이스", "에스프레소", 1);
        orderSystem.orderBeverage("스타벅스", "아메리카노", 1);

        orderSystem.orderBeverage("스타벅스", "카페모카", 2);  // 메뉴에 없는 음료 주문

        System.out.println(" ");

        // 주문 내역 출력
        orderSystem.printOrderSummary();
    }
}