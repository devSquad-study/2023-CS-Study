package decorator.beverage;

public abstract class Beverage {
    public enum Size { TALL, GRANDE, VENTI };
    Size size = Size.TALL;
    String description = "제목 없음";

    public String getDescription() {
        return description;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size)
    {
        this.size = size;
    }

    public abstract double cost();
}
