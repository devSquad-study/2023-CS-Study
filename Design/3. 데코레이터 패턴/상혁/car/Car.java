package decorator.car;

public abstract class Car {
    String description = "제목 없음";

    public abstract double cost();

    public String getDescription() {
        return description;
    }
}
