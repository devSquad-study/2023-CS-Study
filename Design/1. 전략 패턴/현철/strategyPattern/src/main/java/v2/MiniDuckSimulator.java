package v2;

import v2.interfaceMass.fly.FlyRocketPowered;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();

        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();

        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered()); // setter 를 통해 동적으로 오리의 행동을 지정할 수 있다.
        model.performFly();
    }
}
