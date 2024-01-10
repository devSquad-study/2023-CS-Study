import computer.Computer;

public class RemoteControl {
    Monitor monitor = new Monitor();
    MotionDesk motionDesk = new MotionDesk();

    Computer computer = new Computer();

    public void power(){
        monitor.start();
        motionDesk.start();
        computer.start();
    }

    public void quit(){
        monitor.quit();
        motionDesk.quit();
    }

    public void remoteDestHeight(int i){
        motionDesk.setHeight(i);
    }
}
