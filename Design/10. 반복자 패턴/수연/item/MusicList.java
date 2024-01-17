package item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MusicList {
    List<Music> musicList;

    public MusicList(){
        musicList = new ArrayList<>();

        addMusic("뉴진스","hype boy");
        addMusic("뉴진스","OMG");
        addMusic("르세라핌","perfect night");
        addMusic("르세라핌","ANTIFRAGILE");
        addMusic("요네즈 켄시","Lady");
        addMusic("요네즈 켄시","번개");
        addMusic("요네즈 켄시","사신");
        addMusic("eill","피날레");
        addMusic("이세계 아이돌","키딩");
        addMusic("우주소녀","이루리");
    }

    private void addMusic(String singer, String name) {
        Music music = new Music(name, singer);
        musicList.add(music);
    }

    public Iterator<Music> musicPlay(){
        return new MusicIterator(musicList);
    }

    public Iterator<Music> infinitMusicPlay(){
        return new InfinitMusicIterator(musicList);
    }
}
