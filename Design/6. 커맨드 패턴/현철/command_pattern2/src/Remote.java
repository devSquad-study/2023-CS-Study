import command.Location;
import command.airconditioner.AirConditioner;
import command.airconditioner.UnableToLowerTemperatureException;
import command.boiler.Boiler;
import command.car.Car;
import command.car.CarState;
import command.gasstove.GasStove;
import command.gasstove.GasStoveLevel;

public class Remote {
    public static void main(String[] args) throws UnableToLowerTemperatureException {
        GasStove gasStove = new GasStove(Location.INDOOR);
        gasStove.initGasStoveTimer();
        Car car = new Car(CarState.OFF);
        Boiler boiler = new Boiler(28, Location.INDOOR);
        AirConditioner airConditioner = new AirConditioner(28, Location.INDOOR);

        System.out.println(airConditioner.getTemperature());
        airConditioner.decreaseTemperature();
        airConditioner.decreaseTemperature();
        airConditioner.decreaseTemperature();
        airConditioner.decreaseTemperature();

        gasStove.setLocation(Location.OUTDOOR);
//        gasStove.setLocation(Location.INDOOR);

        car.increaseTemperature();
        System.out.println(car.getTemperature());
        System.out.println(car.getState());
        car.setTemperature(28);
        car.setState(CarState.ON);
        car.setTemperature(28);
        car.increaseTemperature();
        System.out.println(car.getTemperature());

        gasStove.setLevel(GasStoveLevel.MEDIUM);
        gasStove.setLocation(Location.OUTDOOR);
        
    }
}
