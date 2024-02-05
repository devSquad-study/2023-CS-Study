package factory;

public class ChangeCarFactory extends ToyFactory{
    @Override
    protected void outputToy() {
        System.out.println("변신 자동차가 생산됩니다");
    }

    @Override
    protected void makeToy() {
        System.out.println("변신 자동차가 생산되었습니다.");
    }
}
