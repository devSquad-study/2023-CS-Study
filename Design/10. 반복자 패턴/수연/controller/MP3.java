package controller;

import item.MusicList;

import java.util.Iterator;
import java.util.Random;

public class MP3 {
    MusicList musicList;
    boolean isCheckedInfinit;

    public MP3(){
        musicList = new MusicList();
        isCheckedInfinit = false;
    }

    public MP3(boolean isCheckedInfinit){
        this.isCheckedInfinit = isCheckedInfinit;
    }

    public void playMusic() throws InterruptedException {
        Random random = new Random();
        Iterator iterator;
        if(isCheckedInfinit){
            iterator = musicList.infinitMusicPlay();
        }else {
            iterator = musicList.musicPlay();
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
