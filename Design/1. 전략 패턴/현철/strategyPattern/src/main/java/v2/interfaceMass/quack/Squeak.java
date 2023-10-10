package v2.interfaceMass.quack;

public class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        // 고무 오리의 소리
        System.out.println("squeak");
    }
}
