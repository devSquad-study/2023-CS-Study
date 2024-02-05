package factory;

public class KongsuniPlayDoctor extends ToyFactory{
    @Override
    protected void outputToy() {
        System.out.println("콩순이 의사놀이가 생산됩니다.");
    }

    @Override
    protected void makeToy() {
        System.out.println("콩순이 의사놀이가 생산되었습니다.");
    }
}
