package item;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MusicIterator implements Iterator {
    List<Music> musicList;
    int position = 0;

    public MusicIterator(List<Music> musicList){
        this.musicList = musicList;
    }

    @Override
    public boolean hasNext() {
        return position < musicList.size();
    }

    @Override
    public Object next() {
        return musicList.get(position++);
    }
}
