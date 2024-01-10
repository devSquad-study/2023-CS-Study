package factory;

public class GameMachinePecileCase extends ToyFactory{
    @Override
    protected void outputToy() {
        System.out.println("게임기 필통이 생산됩니다.");
    }

    @Override
    protected void makeToy() {
        System.out.println("게임기 필통이 생산됩었습니다");
    }
}
