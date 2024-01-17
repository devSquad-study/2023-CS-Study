public class Main {
    public static void main(String[] args) throws InterruptedException {
        MusicList musicList = new MusicList();
        MusicPlayer musicPlayer = new MusicPlayer(musicList, true);

        musicPlayer.addMusic(new Music(1, "rain", "태연", 229));
        musicPlayer.addMusic(new Music(2, "I", "태연", 299));
        musicPlayer.addMusic(new Music(3, "U R", "태연", 275));
        musicPlayer.addMusic(new Music(4, "11 : 11", "태연", 230));

        musicPlayer.setPlayInLoop(false);
        musicPlayer.playInLoop();

        System.out.println("---------------------------------------");

        musicPlayer.removeMusic();

        musicPlayer.setPlayInLoop(true);
        musicPlayer.playInLoop();
    }
}
