package command.airconditioner;

import command.Location;

public class AirConditioner {
    private int temperature;
    private Location location;
    private final int MAX_TEMPERATURE = 26;

    public AirConditioner(int temperature, Location location) {
        this.temperature = temperature;
        setLocation(location);
    }

    public void increaseTemperature() {
        temperature++;
    }

    public void decreaseTemperature() throws UnableToLowerTemperatureException {
        if (temperature <= MAX_TEMPERATURE) {
            System.out.println("[ERROR] 26도 이하로 온도를 내릴 수 없습니다.");
        }

        temperature--;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getTemperature() {
        return temperature;
    }

    public Location getLocation() {
        return location;
    }
}
