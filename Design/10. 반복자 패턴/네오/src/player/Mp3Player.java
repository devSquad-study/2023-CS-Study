package player;

import file.File;
import playlist.Playlist;

import java.time.Instant;

public class Mp3Player implements Playable {

    private Playlist playlist;
    private boolean repeat;

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
        System.out.printf("새 재생목록: %s곡\n", playlist.numberOfSongs());
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
        System.out.printf("반복: %s\n", repeat);
    }

    @Override
    public void play() {
        do {
            playlist.getIterator().forEachRemaining(this::playFile);
        } while (repeat);
    }

    private void playFile(File file) {
        System.out.printf("[%s] %s %ssec\n", Instant.now(), file.getTitle(), file.getPlaybackTime());
        try {
            Thread.sleep(file.getPlaybackTime() * 1_000L);
        } catch (InterruptedException e) {
            System.err.printf("[ERROR] 재생중에 문제가 발생했습니다. 다음곡으로 넘어갑니다. 메세지: %s\n", e.getMessage());
        }
    }

}
