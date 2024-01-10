package factory;

public class TeddyBear extends ToyFactory{
    @Override
    protected void outputToy() {
        System.out.println("테디베어가 생산됩니다.");
    }

    @Override
    protected void makeToy() {
        System.out.println("테디베어가 생산되었습니다.");
    }
}
