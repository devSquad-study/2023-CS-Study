package command.boiler;

import command.Location;

public class Boiler {
    private int temperature;
    private Location location;

    private final int MAX_TIME = 1000;

    public Boiler(int temperature, Location location) {
        this.temperature = temperature;
        setLocation(location);
    }

    public void increaseTemperature() {
        temperature++;
    }

    public void decreaseTemperature() {
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
