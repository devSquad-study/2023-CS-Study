public class Printer {
    private volatile static Printer printer;

    private Printer() {
    }

    public static Printer getPrinter() {
        if (printer == null) {
            synchronized (Printer.class) {
                if (printer == null) {
                    printer = new Printer();
                }
            }
        }

        return printer;
    }

    void printing(Computer computer) throws InterruptedException {
        int time = (int) Math.ceil(computer.printCount / 2);
        System.out.println(time + "seconds");
        Thread.sleep(time * 1000L);
    }

    public void printStatus(Computer computer) throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("[request of computer").append(computer.computerNumber).append(", priority: ").append(Thread.currentThread().getPriority()).append("] : ")
                .append(Status.valueOfStatus(computer.request));
        if (computer.request == 1) {
            sb.append(" ").append((int) computer.printCount).append(" sheets of paper");
        }
        System.out.println(sb);

        if (computer.request == 1) {
            printing(computer);
        }
    }
}
