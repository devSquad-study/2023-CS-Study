import file.File;
import player.Mp3Player;
import playlist.Playlist;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Mp3Player mp3Player = new Mp3Player();
        mp3Player.setPlaylist(new Playlist(List.of(
                new File("title01", 144_000L * 3),
                new File("title02", 144_000L * 2),
                new File("title03", 144_000L * 5)
        )));
        mp3Player.setRepeat(false);

        mp3Player.play();

        mp3Player.setRepeat(true);

        mp3Player.play();
    }

}