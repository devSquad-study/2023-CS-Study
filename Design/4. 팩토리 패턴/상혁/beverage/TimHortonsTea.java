package factory.beverage;

public class TimHortonsTea extends Beverage {
    public TimHortonsTea() {
        description = "팀 홀튼 차";
    }

    @Override
    public double cost() {
        return 2.5;
    }
}
