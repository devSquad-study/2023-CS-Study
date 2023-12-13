package main;


class PrintRequest implements Comparable<PrintRequest> {
    private int priority;
    private int printCount;
    private final String employeeName;

    public PrintRequest(int priority, int printCount, String employeeName) {
        this.priority = priority;
        this.printCount = printCount;
        this.employeeName = employeeName;
    }

    public int getPriority() {
        return priority;
    }

    public int getPrintCount() {
        return printCount;
    }

    public void setPrintCount(int countNum) { this.printCount = countNum;}

    public String getEmployeeName() {
        return employeeName;
    }

    @Override
    public int compareTo(PrintRequest other) {
        if (this.priority != other.priority) {
            return Integer.compare(other.priority, this.priority); // 우선순위가 높은 순서대로 정렬
        } else {
            return Integer.compare(this.printCount, other.printCount); // 우선순위가 같으면 인쇄 매수가 적은 순서대로 정렬
        }
    }
}
