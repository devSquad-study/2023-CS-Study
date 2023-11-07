package beverage.cafe;

public class CafeLatte extends Coffee {

    @Override
    public void make() {
        System.out.println("making CafeLatte...");
        System.out.println("job done!");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
