import java.util.ArrayList;
import java.util.Iterator;

public class MusicList {
    ArrayList<Music> musicArrayList = new ArrayList<>();

    public void addMusic(Music music) {
        musicArrayList.add(music);
    }

    public Iterator<Music> musicListIterator() {
        return new MusicListIterator(musicArrayList);
    }

    public static class MusicListIterator implements Iterator<Music> {

        private final ArrayList<Music> musicList;
        private int index;

        public MusicListIterator(ArrayList<Music> musicList) {
            this.musicList = musicList;
        }

        @Override
        public boolean hasNext() {
            return musicList.size() > index;
        }

        @Override
        public Music next() {
            return musicList.get(index++);
        }

        @Override
        public void remove() {
            if (musicList.isEmpty()) {
                throw new IllegalStateException("삭제할 수 있는 항목이 없습니다.");
            }

            musicList.remove(musicList.size() - 1);
        }
    }
}
