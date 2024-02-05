import java.util.Random;

public class Computer implements Runnable {
    int computerNumber;
    int request;
    double printCount;
    int totalPrint = 0;

    public Computer(int computerNumber) {
        this.computerNumber = computerNumber;
        addRandomNumber();
    }

    void addRandomNumber() {
        Random random = new Random();

        request = random.nextInt(3) + 1;

        if (request == 1) {
            printCount = random.nextInt(10) + 1;
        }
    }

    @Override
    public void run() {

    }
}
