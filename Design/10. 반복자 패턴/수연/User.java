import controller.MP3;

import java.util.Iterator;
import java.util.Random;

public class User {
    boolean isCheckedInfinit;
    MP3 mp3;

    public User (){
        isCheckedInfinit = false;
        mp3 = new MP3();
    }

    public User(boolean isCheckedInfinit){
        this.isCheckedInfinit = isCheckedInfinit;
        mp3 = new MP3();
    }

    public void playMusic() throws InterruptedException {
        Random random = new Random();
        Iterator iterator;
        if(isCheckedInfinit){
            iterator = mp3.infinitMusicPlay();
        }else {
            iterator = mp3.musicPlay();
        }

        while(iterator.hasNext()){
            // random 함수를 이용해서 4를 만나면
            // while 문 탈출
            System.out.println(iterator.next());
            if(random.nextInt(10) == 4 && isCheckedInfinit){
                break;
            }
            Thread.sleep(1000);
        }
    }
}
