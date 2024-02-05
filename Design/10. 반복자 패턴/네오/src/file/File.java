package file;

public class File {

    private final String title;
    private final long sampleRate;
    private final long bitDepth;
    private final long sizeByte;

    public File(String title, long sizeByte) {
        this.title = title;
        this.sampleRate = 48_000L; // default sample rate
        this.bitDepth = 24L; // default bit depth
        this.sizeByte = sizeByte;
    }

    public String getTitle() {
        return title;
    }

    public long getPlaybackTime() {
        // in this case ignore compression and there's no max bit rate
        return (sizeByte * 8) / (sampleRate * bitDepth);
    }

}
