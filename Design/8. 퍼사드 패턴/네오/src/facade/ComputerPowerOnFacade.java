package facade;

import java.util.concurrent.ExecutionException;

public interface ComputerPowerOnFacade {

    void start() throws ExecutionException, InterruptedException;

}
