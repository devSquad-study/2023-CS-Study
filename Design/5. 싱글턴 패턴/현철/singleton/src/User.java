import SportsEquipment.Equipment;
import java.util.ArrayList;
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
    static final int MAX_SIZE = 5;

    public User(String name, int start, Map<Integer, Equipment> sportsEquipmentMap) {
        this.name = name;
        this.sportsEquipmentMap = sportsEquipmentMap;
        sequence.add(start);
        addRandomNumber(sequence, 6);
        addRandomNumber(time, 10);
    }

    void addRandomNumber(List<Integer> list, int maxNumber) {
        Set<Integer> randomNumber = new HashSet<>();

        while (randomNumber.size() < User.MAX_SIZE) {
            Random random = new Random();
            int num = random.nextInt(1, maxNumber) + 1;

            randomNumber.add(num);
        }

        list.addAll(randomNumber);
    }

    void training() throws InterruptedException {
        int timeIndex = 0;

        for (int i : sequence) {
            Equipment equipment = sportsEquipmentMap.get(i);
            
            equipment.sleep(time.get(timeIndex) * 1000);
            timeIndex++;
        }
    }
}
