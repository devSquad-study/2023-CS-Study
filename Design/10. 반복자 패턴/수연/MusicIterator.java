package item;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MusicIterator implements Iterator<Music> {
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
    public Music next() {
        return musicList.get(position++);
    }
}
