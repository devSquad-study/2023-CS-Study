package beverage.cafe;

public class Americano extends Coffee {

    @Override
    public void make() {
        System.out.println("making Americano...");
        System.out.println("job done!");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
