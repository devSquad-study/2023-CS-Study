package iteratorPattern;

public class MP3Player {
    private Playlist playlist;

    public MP3Player(Playlist playlist) {
        this.playlist = playlist;
    }

    public void play() throws InterruptedException {
        System.out.println("MP3 Player is playing...");
        Song currentSong = playlist.next();
        System.out.println("Playing: " + currentSong.getTitle());
        Thread.sleep(1000);

        while (playlist.hasNext()) {
            currentSong = playlist.next();
            System.out.println("Playing: " + currentSong.getTitle());
            Thread.sleep(1000);
        }
        System.out.println("MP3 Player stopped.");
    }
}