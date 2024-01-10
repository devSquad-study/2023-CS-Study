package computer;

public class Computer {

    boolean power = false;

    CPUTest cpuTest = new CPUTest();
    GraphCardTest gphCardTest = new GraphCardTest();
    IOTest ioTest = new IOTest();
    MemoryTest memoryTest = new MemoryTest();
    PowerTest powerTest = new PowerTest();

    public void start(){
        power = true;
        try{
            cpuTest.run();
            gphCardTest.run();
            ioTest.run();
            memoryTest.run();
            powerTest.run();
            cpuTest.join();
            gphCardTest.join();
            ioTest.join();
            memoryTest.join();
            powerTest.join();
            System.out.println("컴퓨터의 전원이 켜졌습니다.");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void quit(){
        power = false;
        System.out.println("컴퓨터의 전원이 꺼졌습니다.");
    }


}
