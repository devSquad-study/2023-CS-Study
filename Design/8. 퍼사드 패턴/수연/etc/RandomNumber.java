package etc;

import java.util.Random;

public class RandomNumber {
    private static int createNumber(){
        Random random = new Random();
        int number = random.nextInt(4)+1;
        return number;
    }

    public static int createError(){
        int number = createNumber();
        if(number == 4){
            throw new IllegalArgumentException("컴퓨터를 켜는 데 문제가 발생하였습니다");
        }
        return number;
    }
}
