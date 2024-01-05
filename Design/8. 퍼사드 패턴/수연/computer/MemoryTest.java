package computer;

import etc.RandomNumber;

public class MemoryTest extends Thread {

    private int status;

    @Override
    public void run() {
        try{
            status = RandomNumber.createError();
        }catch (IllegalArgumentException e){
            throw e;
        }
    }
}
