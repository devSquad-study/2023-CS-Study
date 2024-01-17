package iteratorPattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 노래 생성
        Song song1 = new Song("가을이긴 한가봐");
        Song song2 = new Song("폰서트");
        Song song3 = new Song("소년");

        // 플레이리스트 생성 및 노래 추가
        Playlist playlist = new Playlist();
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        // 전체 반복 옵션 설정
        playlist.setRepeatAll(false);

        // MP3 플레이어 생성 및 플레이리스트 설정
        MP3Player mp3Player = new MP3Player(playlist);

        // MP3 플레이어 실행
        mp3Player.play();
    }
}