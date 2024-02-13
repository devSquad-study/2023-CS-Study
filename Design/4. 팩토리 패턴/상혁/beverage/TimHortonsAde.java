package factory.beverage;

public class TimHortonsAde extends Beverage {
    public TimHortonsAde() {
        description = "팀 홀튼 에이드";
    }

    @Override
    public double cost() {
        return 2;
    }
}
