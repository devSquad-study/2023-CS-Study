package data;

import util.RandomIntegerGenerator;

public record Data(
        Thread requester,
        Header header,
        Body body
) implements Comparable<Data> {

    private static final int MIN_PAGES = 1;
    private static final int MAX_PAGES = 10;

    public Data(Thread thread) {
        this(
                thread,
                new Header(Priority.values()[RandomIntegerGenerator.asInt(Priority.values().length)]),
                new Body(
                        String.format("%s의 문서", thread.getName()),
                        RandomIntegerGenerator.asInt(MIN_PAGES, MAX_PAGES)
                )
        );
    }

    @Override
    public int compareTo(Data data) {
        return data.header.priority().compareTo(this.header.priority());
    }

}
