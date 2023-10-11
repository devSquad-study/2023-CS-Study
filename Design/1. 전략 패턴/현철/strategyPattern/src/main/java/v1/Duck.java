package v1;

public class Duck {
    void quack() {

    }

    void swim() {

    }

    void fly() {

    }

    void display() {

    }
}

class MallardDuck extends Duck {
    @Override
    void display() {

        // 적당한 모양을 표시
        super.display();
    }
}

class RedHeadDuck extends Duck{
    @Override
    void display() {

        // 적당한 모양을 표시
        super.display();
    }
}

class RubberDuck extends Duck{
    @Override
    void quack() {

        // 소리를 내도록 오버라이드
        super.quack(); // 고무 오리는 실제 오리와는 다른 소리이므로 오바라이딩 해서 다른 소리 내도록 변
    }
}