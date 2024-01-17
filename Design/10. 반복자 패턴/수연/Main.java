import controller.MP3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MP3 mp3 = new MP3();
        mp3.playMusic();

        System.out.println();
        System.out.println("--------------");
        System.out.println();

        mp3 = new MP3(true);
        mp3.playMusic();

    }
}