package v2.interfaceMass.quack;

public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        // 아무 소리도 내지 않음
        System.out.println("mute");
    }
}
