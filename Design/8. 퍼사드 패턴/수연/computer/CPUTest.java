package computer;

import etc.RandomNumber;

public class CPUTest extends Thread{
    private int status;

    @Override
    public void run() throws IllegalArgumentException{
        try{
            status = RandomNumber.createError();
        }catch (IllegalArgumentException e){
            throw e;
        }

    }
}
