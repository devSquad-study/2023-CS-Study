package fly;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("하늘을 바라만 봅니다");
    }
}
