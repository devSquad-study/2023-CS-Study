package main;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Printer {
    private static Printer instance = null;
    private boolean isPrinting;
    private int printSpeed;
    private final PriorityQueue<PrintRequest> printQueue;
    private final Lock lock;

    private Printer() {
        isPrinting = false;
        printSpeed = 2; // 초당 인쇄 속도
        printQueue = new PriorityQueue<>(Comparator.comparing(PrintRequest::getPriority).reversed());
        lock = new ReentrantLock();
    }

    public static Printer getInstance() {
        if (instance == null) {
            instance = new Printer();
        }
        return instance;
    }

    public void addRequest(PrintRequest request) {
        printQueue.offer(request);
        printQueueStatus(); // 현재 대기열 출력
        processQueue();
    }

    public void cancelCurrentPrint() {
        if (!printQueue.isEmpty()) {
            PrintRequest currentRequest = printQueue.poll();
            System.out.println("[취소] 인쇄 중인 요청 취소됨 - 직원: " + currentRequest.getEmployeeName() +
                    ", 우선순위: " + currentRequest.getPriority() + ", 인쇄 매수: " + currentRequest.getPrintCount());
            isPrinting = false;
            processQueue();
        }
    }

    private void processQueue() {
        if (!isPrinting && !printQueue.isEmpty()) { // 인쇄가 가능할 경우

            PrintRequest nextRequest = printQueue.poll();
            isPrinting = true;
            int remainingPrint = nextRequest.getPrintCount() - 2;

            System.out.println("[인쇄 시작] - 직원: " + nextRequest.getEmployeeName() +
                    ", 우선순위: " + nextRequest.getPriority() + ", 인쇄 매수: " + nextRequest.getPrintCount() + "중 " + Math.min(2,nextRequest.getPrintCount()) + "매 프린트");

            try {
                Thread.sleep(1000 / printSpeed); // 인쇄 속도에 따라 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("[인쇄 완료] - 직원: " + nextRequest.getEmployeeName() +
                    ", 우선순위: " + nextRequest.getPriority() + ", 인쇄 매수: " + Math.min(2,nextRequest.getPrintCount()));

            if (remainingPrint > 0) {
                nextRequest.setPrintCount(remainingPrint);
                printQueue.offer(nextRequest);
            }

            isPrinting = false;

//            processQueue(); // 처리가 완료되면 다음 요청 처리
        }
    }

    public void printQueueStatus() {
        System.out.print("[대기열 상태] ");
        if (printQueue.isEmpty()) {
            System.out.println("대기열이 비었습니다.");
        } else {
            for (PrintRequest request : printQueue) {
                System.out.print("[직원: " + request.getEmployeeName() +
                        ", 우선순위: " + request.getPriority() +
                        ", 인쇄 매수: " + request.getPrintCount() + "] ");
            }
            System.out.println();
        }
    }

    public boolean hasCancellationRequest(String employeeName) {
        for (PrintRequest request : printQueue) {
            if (request.getEmployeeName().equals(employeeName)) {
                return true;
            }
        }
        return false;
    }
}
