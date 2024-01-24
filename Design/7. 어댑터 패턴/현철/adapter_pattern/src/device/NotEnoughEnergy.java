package device;

public class NotEnoughEnergy extends RuntimeException {
    public NotEnoughEnergy() {

    }
    public NotEnoughEnergy(String message) {
        super(message);
    }
}
