package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Employee implements Runnable {
    private final Printer printer;
    private final String name; // 직원의 이름 추가
    private static final List<String> status = List.of("요청", "취소", "대기");


    public Employee(Printer printer, String name) {
        this.printer = printer;
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        int requestCount = 0;

        while (requestCount < 3) {
            int action = random.nextInt(3); // 0: 요청, 1: 요청 취소, 2: 대기
            if (action == 0) {
                requestCount++;
                int priority = random.nextInt(5) + 1;
                int printCount = random.nextInt(10) + 1;

                System.out.println(name + "의 " + requestCount + "번째 요청은 " + status.get(action));
                printer.addRequest(new PrintRequest(priority, printCount, name));
            } else if (action == 1) {
                if (printer.hasCancellationRequest(name)) {
                    requestCount++;
                    System.out.println(name + "의 " + requestCount + "번째 요청은 " + status.get(action));

                    printer.cancelCurrentPrint();
                }
            }
            try {
                Thread.sleep(random.nextInt(5000) + 1000); // 1초에서 6초 사이의 랜덤 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            printer.printQueueStatus(); // 대기열 상태 출력
        }
        System.out.println(name + "의 요청 세번이 종료되었습니다.");
    }
}
