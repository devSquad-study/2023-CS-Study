import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        HashMap<Integer, Computer> map = new HashMap<>();
        List<Thread> list = new ArrayList<>();
        Random random = new Random();
        boolean checkWhile = true;

        for (int i = 1; i <= 5; i++) {
            map.put(i, new Computer(i));
        }

        while (checkWhile) {
            int randomComputer = random.nextInt(4) + 1;
            int randomPriority = random.nextInt(4) + 1;

            if (map.get(randomComputer).totalPrint > 3) {
                continue;
            }
            map.get(randomComputer).totalPrint++;

            Thread thread = new Thread(() -> {
                try {
                    Printer.getPrinter().printStatus(map.get(randomComputer));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });

            thread.setPriority(randomPriority);
            list.add(thread);

            checkWhile = check(map);
        }

        for (Thread task : list) {
            task.start();
            task.join();
        }


    }

    static boolean check(HashMap<Integer, Computer> map) {
        return map.get(1).totalPrint != 3 && map.get(2).totalPrint != 3 && map.get(3).totalPrint != 3
                && map.get(4).totalPrint != 3 && map.get(5).totalPrint != 3;
    }
}
