package playlist;

import file.File;

import java.util.Iterator;
import java.util.List;

public class Playlist {

    private final List<File> files;

    public Playlist(List<File> files) {
        assert files != null;
        this.files = List.copyOf(files);
    }

    public int numberOfSongs() {
        return files.size();
    }

    public Iterator<File> getIterator() {
        return new PlaylistIterator(files);
    }

    public static class PlaylistIterator implements Iterator<File> {

        private final List<File> files;
        private int next;

        public PlaylistIterator(List<File> files) {
            this.files = files;
            this.next = 0;
        }

        @Override
        public boolean hasNext() {
            return files.size() > next;
        }

        @Override
        public File next() {
            return files.get(next++);
        }

    }
}
