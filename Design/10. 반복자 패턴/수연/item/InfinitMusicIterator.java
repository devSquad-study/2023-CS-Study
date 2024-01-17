package item;

import java.util.Iterator;
import java.util.List;

public class InfinitMusicIterator implements Iterator<Music> {
    List<Music> musicList;
    int position = 0;

    public InfinitMusicIterator(List<Music> musicList){
        this.musicList = musicList;
    }

    @Override
    public boolean hasNext() {
        if(position >= musicList.size()){
            position = 0;
        }
        return true;
    }

    @Override
    public Music next() {
        return musicList.get(position++);
    }
}
