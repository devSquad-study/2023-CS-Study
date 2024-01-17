package iteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Playlist implements Iterator<Song> {
    private List<Song> songs;
    private int currentSongIndex;
    private boolean repeatAll;

    public Playlist() {
        this.songs = new ArrayList<>();
        this.currentSongIndex = 0;
        this.repeatAll = false;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void setRepeatAll(boolean repeatAll) {
        this.repeatAll = repeatAll;
    }

    @Override
    public boolean hasNext() {
        if (repeatAll) {
            currentSongIndex = (currentSongIndex + 1) % songs.size();
            return true;
        } else if (currentSongIndex < songs.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Song next() {
        Song song = songs.get(currentSongIndex);
//        currentSongIndex = (currentSongIndex + 1) % songs.size();
        currentSongIndex = (currentSongIndex + 1);
        return song;
    }
}
