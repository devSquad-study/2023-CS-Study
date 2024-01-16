package main;


import main.factory.ToyFactory;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 고객 주문
        List<Order> orders = Arrays.asList(
                new Order("변신 자동차", "서울시 강남구", "010-1234-5678"),
                new Order("곰돌이", "경기도 수원시", "010-1234-5678"),
                new Order("콩순이 의사놀이", "대구 광역시", "010-1234-5678"),
                new Order("게임기 필통", "부산 광역시", "010-1234-5678")
        );

        ToyFactory factory;

        // 주문 처리
        for (Order order : orders) {
            factory = order.createFactory();
            if (factory != null) {
                factory.prepareToy(order.getCustomerAddress());
                System.out.println();
            }
        }
    }
}

