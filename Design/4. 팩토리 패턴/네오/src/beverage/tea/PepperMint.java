package beverage.tea;

public class PepperMint extends Tea {

    @Override
    public void make() {
        System.out.println("making PepperMin...");
        System.out.println("job done!");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
