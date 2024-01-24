public class Music {
    int index;
    String title;
    String singer;
    int second;

    public Music(int index, String title, String singer, int second) {
        this.index = index;
        this.title = title;
        this.singer = singer;
        this.second = second;
    }

    @Override
    public String toString() {

        return "title: " + title + ", " + "singer: " + singer + ", " + "second: " + second + "s";
    }
}
