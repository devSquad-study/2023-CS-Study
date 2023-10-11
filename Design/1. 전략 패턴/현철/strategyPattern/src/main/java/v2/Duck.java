package v2;

import v2.interfaceMass.fly.FlyBehavior;
import v2.interfaceMass.quack.QuackBehavior;


public abstract class Duck {
    // 클래스는 원래 어떤 대상을 나타내는 것. 일반적으로 상태(인스턴스 변수)와 메소드를 둘 다 가지고 있음. 하지만 interfaceMass 패키지안의 클래스 들은 행동만을 가지고 있음.
    // 하지만 행동에도 상태가 있을 수 있음. 나는 행동에 속성(분당 날개짓 횟수, 최대 고도, 속도 등)을 나타내는 인스턴스 변수를 넣을 수 있음.

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    // 서브 클래스에서 실행 시 이 변수에 특정 행동 형식의 레퍼런스를 다형적으로 설정.

    public Duck() {

    }

    public void swim() {
        System.out.println("가짜와 진짜 오리 모두 물위에 뜸.");
    }


    void performFly() {
        // 객체의 종류에는 신경 쓸 필요 없이 fly()를 실행할 줄 알면 됨.
        flyBehavior.fly();
    }

    void performQuack() {
        // 객체의 종류에는 신경 쓸 필요 없이 quack()을 실행할 줄 알면 됨.
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
