package facade;

import device.Computer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ComputerPowerOnFacadeImpl implements ComputerPowerOnFacade {

    private Computer computer;

    public ComputerPowerOnFacadeImpl(Computer computer) {
        this.computer = computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void start() {
        // 리플렉션을 사용한 예제
        Arrays.stream(computer.getClass().getMethods()).parallel().forEach(method -> {
            if (Modifier.isPublic(method.getModifiers()) && method.getDeclaringClass() == computer.getClass()) {
                try {
                    method.invoke(computer);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // CompletableFuture를 사용한 예제
        //var power = CompletableFuture.runAsync(computer::checkPower);
        //var memory = CompletableFuture.runAsync(computer::checkMemory);
        //var cpu = CompletableFuture.runAsync(computer::checkCpu);
        //var gpu = CompletableFuture.runAsync(computer::checkGpu);
        //var io = CompletableFuture.runAsync(computer::checkIO);

        //power.join();
        //memory.join();
        //cpu.join();
        //gpu.join();
        //io.join();
    }

}
