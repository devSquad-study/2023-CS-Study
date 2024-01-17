public class Main {
    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        user.playMusic();

        System.out.println();
        System.out.println("--------------");
        System.out.println();

        User user1 = new User(true);
        user1.playMusic();
    }
}