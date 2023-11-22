import SportsEquipment.Equipment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class User {
    String name;
    List<Integer> sequence = new ArrayList<>();
    List<Integer> time = new ArrayList<>();
    Map<Integer, Equipment> sportsEquipmentMap;
    static int MAX_SIZE = 5;

    public User(String name, int start, Map<Integer, Equipment> sportsEquipmentMap) {
        this.name = name;
        this.sportsEquipmentMap = sportsEquipmentMap;
        sequence.add(start);
        addRandomNumber(sequence, 6, MAX_SIZE);
        addRandomNumber(time, 10, MAX_SIZE);
    }

    void addRandomNumber(List<Integer> list, int maxNumber, int maxSize) {
        Set<Integer> randomNumber = new HashSet<>();
        Random random = new Random(maxNumber + 1);

        while (randomNumber.size() < maxSize) {
            int time = random.nextInt();
            randomNumber.add(time);
        }

        list.addAll(randomNumber);
    }

    void training() throws InterruptedException {
        int timeIndex = 0;

        for (int i : sequence) {
            Equipment equipment = sportsEquipmentMap.get(i);
            for(int j : sequence) {
                System.out.println(j+ "초");
            }
            System.out.println(sportsEquipmentMap.get(i) + "운동을 " + time.get(timeIndex) + "초 동안 사용 중");
            equipment.sleep(time.get(timeIndex) * 1000);
            timeIndex++;
        }
    }
}
