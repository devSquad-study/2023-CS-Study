package factory;

public abstract class ToyFactory {
    // 장난감을 가동하는 메소드
    // 장난감을 만드는 메소드
    // 장난감이 완성을 알리는 메소드

    public final void runFactory(){
        startFactory();
        makeToy();
        outputToy();
    }

    protected abstract void outputToy();

    protected abstract void makeToy();

    private void startFactory() {
        System.out.println("공장을 가동합니다.");
    }
}
