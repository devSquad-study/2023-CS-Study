import java.util.ArrayList;
import java.util.List;
import toy.Bear;
import toy.Car;
import toy.DeliveryToy;
import toy.Doctor;
import toy.GamePencilCase;

public class Main {
    public static void main(String[] args) {
        DeliveryToy bear = new Bear();
        DeliveryToy car = new Car();
        DeliveryToy doctor = new Doctor();
        DeliveryToy gamePencilCase = new GamePencilCase();

        List<DeliveryToy> toys = new ArrayList<>();
        toys.add(bear);
        toys.add(car);
        toys.add(doctor);
        toys.add(gamePencilCase);

        for (DeliveryToy toy : toys) {
            System.out.println(toy.getClass().getSimpleName());
        }
    }
}
