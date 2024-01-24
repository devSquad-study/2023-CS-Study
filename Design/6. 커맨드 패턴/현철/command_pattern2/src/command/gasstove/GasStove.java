package command.gasstove;

import command.Location;

public class GasStove {
    private Location location;
    private GasStoveLevel level;
    private GasStoveTimer gasStoveTimer;
    private boolean isSetTimer = true;

    public GasStove(Location location) {
        setLocation(location);

        level = GasStoveLevel.OFF;
    }

    public void setLevel(GasStoveLevel level) {

        this.level = level;
    }

    public GasStoveLevel getLevel() {
        return level;
    }

    public void setLocation(Location location) {
        if (location == Location.OUTDOOR && level != GasStoveLevel.OFF) {
            gasStoveTimer.start();
            isSetTimer = true;
        } else if (location == Location.INDOOR && isSetTimer && gasStoveTimer != null) {
            isSetTimer = false;
            gasStoveTimer.stop();
        }

        this.location = location;

    }

    public Location getLocation() {
        return location;
    }

    public void initGasStoveTimer() {
        this.gasStoveTimer = new GasStoveTimer(this);
    }
}
