package main;


public class Main {
    public static void main(String[] args) {
        Printer printer = Printer.getInstance();

        String[] employeeNames = {"네오", "수연", "현철", "상혁", "은선"};
        Employee[] employees = new Employee[5];
        for (int i = 0; i < 5; i++) {
            employees[i] = new Employee(printer, employeeNames[i]); // 배열에 직원 객체 추가
            Thread employeeThread = new Thread(employees[i]);
            employeeThread.start();
        }
    }
}
