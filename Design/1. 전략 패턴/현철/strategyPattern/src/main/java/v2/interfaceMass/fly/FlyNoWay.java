package v2.interfaceMass.fly;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        // 날 수 없는 오리
        System.out.println("날지 못하는 오리");
    }
}
