import java.util.Iterator;

public class MusicPlayer {
    private final MusicList musicList;
    public boolean playInLoop;

    public MusicPlayer(MusicList musicList, boolean playInLoop) {
        this.musicList = musicList;
        this.playInLoop = playInLoop;
    }

    public void addMusic(Music music) {
        musicList.addMusic(music);
    }

    public void removeMusic() {
        musicList.musicListIterator().remove();
    }

    public void playInLoop() throws InterruptedException {
        Iterator<Music> musicIterator = musicList.musicListIterator();

        do {
            if (!musicIterator.hasNext()) {
                musicIterator = musicList.musicListIterator(); // Reset the iterator when we reach the end
            }

            while (musicIterator.hasNext()) {
                System.out.println(musicIterator.next().toString());
                Thread.sleep(1000);
            }

        }
        while (playInLoop);
    }

    public void setPlayInLoop(boolean playInLoop) {
        this.playInLoop = playInLoop;
    }
}
