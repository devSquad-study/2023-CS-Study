package factory.beverage;

public class TimHortonsCoffee extends Beverage {
    public TimHortonsCoffee() {
        description = "팀 홀튼 커피";
    }

    @Override
    public double cost() {
        return 3.0;
    }
}
