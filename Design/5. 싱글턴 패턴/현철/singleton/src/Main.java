import SportsEquipment.BenchPress;
import SportsEquipment.Equipment;
import SportsEquipment.LatPullDown;
import SportsEquipment.LegPress;
import SportsEquipment.RowingMachine;
import SportsEquipment.SquatRack;
import SportsEquipment.Treadmill;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Equipment> sportsEquipmentMap = new HashMap<>();

        sportsEquipmentMap.put(1, RowingMachine.getRowingMachine());
        sportsEquipmentMap.put(2, SquatRack.getSquatRack());
        sportsEquipmentMap.put(3, Treadmill.getTreadmill());
        sportsEquipmentMap.put(4, BenchPress.getBenchPress());
        sportsEquipmentMap.put(5, LatPullDown.getLatPullDown());
        sportsEquipmentMap.put(6, LegPress.getLegPress());

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Runnable> list = getRunnables(sportsEquipmentMap, executorService);

        for (Runnable task : list) {
            executorService.submit(task);
        }
    }

    private static List<Runnable> getRunnables(Map<Integer, Equipment> sportsEquipmentMap,
                                               ExecutorService executorService) {
        List<Runnable> list = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            int finalI = i;

            list.add(() -> {
                try {
                    new User("user" + finalI, finalI, sportsEquipmentMap).training();
                } catch (Exception e) {
                    executorService.shutdown();

                    throw new RuntimeException(e);
                }
            });
        }

        return list;
    }
}
