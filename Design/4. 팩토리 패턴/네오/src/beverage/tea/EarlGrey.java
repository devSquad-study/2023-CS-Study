package beverage.tea;

public class EarlGrey extends Tea {

    @Override
    public void make() {
        System.out.println("making EarlGrey...");
        System.out.println("job done!");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
